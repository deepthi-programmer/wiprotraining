package day23;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;
public class ThreadPoolExample {

	public static void main(String[] args) {
		 ExecutorService executorService = Executors.newFixedThreadPool(4);

	        // List to hold the Future objects associated with Callable tasks
	        List<Future<Long>> futureList = new ArrayList<>();
	        for (int i = 1; i <= 10; i++) {
	            int taskId = i;
	            Callable<Long> task = () -> {
	                // Simulate complex calculation
	                long sum = 0;
	                for (long j = 0; j < 1000000L; j++) {
	                    sum += j;
	                }
	                System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
	                return sum;
	            };
	            Future<Long> future = executorService.submit(task);
	            futureList.add(future);
	        }
	        for (Future<Long> future : futureList) {
	            try {
	                System.out.println("Result: " + future.get());
	            } catch (InterruptedException | ExecutionException e) {
	                e.printStackTrace();
	            }
	        }
	        executorService.shutdown();
		// TODO Auto-generated method stub

	}

}
