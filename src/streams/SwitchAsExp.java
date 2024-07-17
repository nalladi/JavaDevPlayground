public class SwitchAsExp {
    enum EmployeeType {
        SALARIED, FREELANCER
    }
    public static void main(String[] args) {
        int day = 3;
        int month = 8;
        EmployeeType employeeType = EmployeeType.SALARIED;
        String dayName = switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };
        String season = switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
        System.out.println(dayName); // Outputs: Tuesday
        System.out.println(season); // Outputs: Summer
        switch (employeeType) {
            case SALARIED -> System.out.println("Processing salaried employee.");
            case FREELANCER -> System.out.println("Processing freelancer employee.");
            // No default branch needed if all enum cases are covered
        }
    }
}
