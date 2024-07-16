import java.time.LocalDateTime;

public record LogRecord(LocalDateTime timestamp, String customerId, String webPageId) { }
