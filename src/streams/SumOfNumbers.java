
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 20, 44, 37, 88, 99, 50, 20, 5, 33);
        System.out.println(list.stream().reduce(0,Integer::sum));
        double average = list.stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(Double.NaN);
        System.out.println(average);
    }
}
