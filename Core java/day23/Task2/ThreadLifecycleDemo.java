package day23;

public class ThreadLifecycleDemo {

	public static void main(String[] args) {
		 final Object lock = new Object();

	        Thread thread = new Thread(() -> {
	            try {
	                // RUNNABLE: The thread is in the ready state, ready to run.
	                System.out.println("State: RUNNABLE");

	                // TIMED_WAITING: The thread is sleeping for a specified amount of time.
	                Thread.sleep(1000);
	                System.out.println("State: TIMED_WAITING (after sleep)");
	                synchronized (lock) {
	                    // WAITING: The thread waits indefinitely for another thread to notify it.
	                    lock.wait();
	                    System.out.println("State: WAITING");
	                }

	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println("State: RUNNABLE (after notify)");

	            // TERMINATED: The thread has completed execution.
	            System.out.println("State: TERMINATED");
	        });
	        System.out.println("State: NEW");
	        
	        thread.start();

	        // Ensure the thread is in TIMED_WAITING state
	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        synchronized (lock) {
	            // Notify the thread to move it from WAITING to RUNNABLE.
	            lock.notify();
	            System.out.println("State: BLOCKED (main thread holds the lock, child is waiting)");
	        }
	        try {
	            thread.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		// TODO Auto-generated method stub

	}

}
