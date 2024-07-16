import java.util.*;

public class SendAndHashSet {
    public static void main(String[] args){
        Set<String> names = new HashSet<>();
        names.add("Nagesh");
        names.add("Vasudha");
        names.add("Sahiti");
        names.add("Pranati");
        names.forEach(System.out::println);
        List<Integer> numList = List.of(1, 2, 5,6, 0, 4, 8, 5, 6);
        System.out.println(numList);
        Set<Integer> numSet = new HashSet<>(numList);
        Set<String> numTreeSet = new TreeSet<>(names);
        System.out.println(numSet);
       numTreeSet.forEach(System.out::println);
    }
}
