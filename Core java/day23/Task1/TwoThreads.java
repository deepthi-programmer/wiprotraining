package day23;

public class TwoThreads {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new NumberPrinter(), "Thread-1");
		
		Thread thread2 = new Thread(new NumberPrinter(), "Thread-2");
		thread1.start();
		 thread2.start();
		// TODO Auto-generated method stub

	}

}
class NumberPrinter implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                // Print the thread name and the current number
                System.out.println(Thread.currentThread().getName() + ": " + i);
                // Wait for 1 second
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
    }
}
