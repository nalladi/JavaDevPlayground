import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * How virtual threads are switching from one platform thread to another.
 *
 */
public class VTSwitchToDifferentPT {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = IntStream.range(0, 10)
                .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
                    if (i == 0) {
                        System.out.println(Thread.currentThread());
                    }
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    if (i == 0) {
                        System.out.println(Thread.currentThread());
                    }
                })).toList();

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
    }
}


