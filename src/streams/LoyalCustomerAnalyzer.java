import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;


public class LoyalCustomerAnalyzer {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static void main(String[] args) {
        if(args.length < 2) {
            System.err.println("Usage: expected two dates");
            System.exit(1);
        }
        String dayXLogFile = args[0];
        String dayYLogFile = args[1];

        Map<String, Set<String>> dayXLogs = readLogs(dayXLogFile);
        Map<String, Set<String>> dayYLogs = readLogs(dayYLogFile);

        Set<String> loyalCustomers = findLoyalCustomers(dayXLogs, dayYLogs);

        System.out.println("Loyal Customers: " + loyalCustomers);

    }


    private static Set<String> findLoyalCustomers(Map<String, Set<String>> dayXLogs, Map<String, Set<String>> dayYLogs) {
        return Set.of();
    }

    private static Map<String, Set<String>> readLogs(String dayXLogFile) {
        return Map.of();
    }
}
