import java.util.*;
import java.util.stream.Collectors;


class JavaStream1 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            people.add(new Person("Person" + i, i % 100));
        }

        long startTime = System.nanoTime();

        // Traditional Loop
        List<String> names1 = new ArrayList<>();
        for (Person person : people) {
            if (person.age() > 18) {
                names1.add(person.name().toUpperCase());
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Traditional Loop Time: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();

        // Stream
        List<String> names2 = people.stream()
                .filter(person -> person.age() > 18)
                .map(person -> person.name().toUpperCase())
                .collect(Collectors.toList());

        endTime = System.nanoTime();
        System.out.println("Stream Time: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();

        // Parallel Stream
        List<String> names3 = people.parallelStream()
                .filter(person -> person.age() > 18)
                .map(person -> person.name().toUpperCase())
                .collect(Collectors.toList());

        endTime = System.nanoTime();
        System.out.println("Parallel Stream Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}

