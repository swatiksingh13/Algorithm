package in.design.algodesign.service;

import in.design.algodesign.model.LogEntry;
import in.design.algodesign.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlgorithmService {
    private final LogRepository logRepository;

    public AlgorithmService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                saveLog("Binary Search", Arrays.toString(arr) + ", target=" + target, String.valueOf(mid));
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        saveLog("Binary Search", Arrays.toString(arr) + ", target=" + target, "-1");
        return -1;
    }

    public int[] quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
        saveLog("Quick Sort", Arrays.toString(arr), Arrays.toString(arr.clone()));
        return arr;
    }

    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        saveLog("BFS", graph.toString() + ", startNode=" + startNode, result.toString());
        return result;
    }

    private void saveLog(String algorithm, String input, String output) {
        LogEntry log = new LogEntry(algorithm, input, output);
        logRepository.save(log);
    }
}
