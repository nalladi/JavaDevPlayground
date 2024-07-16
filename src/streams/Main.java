import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            people.add(new Person("Person" + i, i % 100));
        }

        // Traditional Loop Runnable
        Runnable traditionalLoopTask = () -> {
            long startTime = System.nanoTime();
            List<String> names1 = new ArrayList<>();
            for (Person person : people) {
                if (person.age() > 18) {
                    names1.add(person.name().toUpperCase());
                }
            }
            long endTime = System.nanoTime();
            System.out.println("Traditional Loop Time: " + (endTime - startTime) / 1e6 + " ms");
        };

        // Stream Runnable
        Runnable streamTask = () -> {
            long startTime = System.nanoTime();
            List<String> names2 = people.stream()
                    .filter(person -> person.age() > 18)
                    .map(person -> person.name().toUpperCase())
                    .collect(Collectors.toList());
            long endTime = System.nanoTime();
            System.out.println("Stream Time: " + (endTime - startTime) / 1e6 + " ms");
        };

        // Parallel Stream Runnable
        Runnable parallelStreamTask = () -> {
            long startTime = System.nanoTime();
            List<String> names3 = people.parallelStream()
                    .filter(person -> person.age() > 18)
                    .map(person -> person.name().toUpperCase())
                    .collect(Collectors.toList());
            long endTime = System.nanoTime();
            System.out.println("Parallel Stream Time: " + (endTime - startTime) / 1e6 + " ms");
        };

        // Creating virtual threads for each task
        Thread traditionalLoopThread = Thread.ofVirtual().start(traditionalLoopTask);
        Thread streamThread = Thread.ofVirtual().start(streamTask);
        Thread parallelStreamThread = Thread.ofVirtual().start(parallelStreamTask);

        // Waiting for virtual threads to finish
        traditionalLoopThread.join();
        streamThread.join();
        parallelStreamThread.join();
    }
}