package day23;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
public class PrimeNumberCalculator {
	public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
	public static List<Integer> calculatePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
	public static CompletableFuture<Void> writePrimesToFile(List<Integer> primes, String filename) {
        return CompletableFuture.runAsync(() -> {
            try {
                Files.write(Paths.get(filename), primes.stream().map(String::valueOf).collect(Collectors.toList()));
                System.out.println("Primes written to file: " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

	public static void main(String[] args) {
		int limit = 100000; // Change the limit as needed
        int numberOfThreads = 4;

        // Create a fixed-size thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        // List to hold Future objects
        List<Future<List<Integer>>> futures = new ArrayList<>();
        int chunkSize = limit / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize + 1;
            int end = (i == numberOfThreads - 1) ? limit : (i + 1) * chunkSize;
            Callable<List<Integer>> task = () -> calculatePrimes(end);
            futures.add(executorService.submit(task));
        }
        List<Integer> allPrimes = new ArrayList<>();
        for (Future<List<Integer>> future : futures) {
            try {
                allPrimes.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        CompletableFuture<Void> fileWriteFuture = writePrimesToFile(allPrimes, "primes.txt");
        fileWriteFuture.join();

        System.out.println("All tasks completed.");
        
		// TODO Auto-generated method stub

	}

}
