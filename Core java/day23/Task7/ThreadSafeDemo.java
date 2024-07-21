package day23;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class Counter {
    private int count;

    // Synchronized increment method
    public synchronized void increment() {
        count++;
    }

    // Synchronized decrement method
    public synchronized void decrement() {
        count--;
    }
    public synchronized int getCount() {
        return count;
    }
}
final class ImmutableData {
    private final int value;

    public ImmutableData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
public class ThreadSafeDemo {

	public static void main(String[] args) {
		Counter counter = new Counter();

        // Create a fixed-size thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Submit tasks to increment and decrement the counter
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.decrement();
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Counter Value: " + counter.getCount());

        // Demonstrate usage of ImmutableData
        ImmutableData data = new ImmutableData(42);
        System.out.println("Immutable Data Value: " + data.getValue());
		

	}

}
