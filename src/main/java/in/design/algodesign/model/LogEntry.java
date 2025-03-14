package in.design.algodesign.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "algorithm_logs")
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "algorithm_name")
    private String algorithmName;

    @Column(columnDefinition = "TEXT")
    private String inputData;

    @Column(columnDefinition = "TEXT")
    private String outputData;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public LogEntry(String algorithmName, String inputData, String outputData) {
        this.algorithmName = algorithmName;
        this.inputData = inputData;
        this.outputData = outputData;
        this.timestamp = LocalDateTime.now();
    }

    public LogEntry() { }
}
