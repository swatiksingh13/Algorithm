package in.design.algodesign.controller;

import in.design.algodesign.service.AlgorithmService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AlgorithmController {
    private final AlgorithmService algorithmService;

    public AlgorithmController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @PostMapping("/search/binary")
    public int binarySearch(@RequestParam int[] arr, @RequestParam int target) {
        return algorithmService.binarySearch(arr, target);
    }

    @PostMapping("/sort/quick")
    public int[] quickSort(@RequestParam int[] arr) {
        return algorithmService.quickSort(arr);
    }

    @PostMapping("/traverse/bfs")
    public List<Integer> bfs(@RequestBody Map<Integer, List<Integer>> graph, @RequestParam int startNode) {
        return algorithmService.bfs(graph, startNode);
    }
}
