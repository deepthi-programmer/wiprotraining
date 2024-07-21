package day23;
import java.util.LinkedList;
import java.util.Queue;
class SharedBuffer {
    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();
   
    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }
    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        System.out.println("Produced: " + item);
        notifyAll();
    }
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int item = queue.poll();
        System.out.println("Consumed: " + item);
        notifyAll();
        return item;
    }
}
class Producer implements Runnable {
    private final SharedBuffer buffer;
   
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        int item = 0;
        while (true) {
            try {
                buffer.produce(item++);
                Thread.sleep(100); // Simulate time taken to produce item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable {
    private final SharedBuffer buffer;
   
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(150); // Simulate time taken to consume item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		SharedBuffer buffer = new SharedBuffer(5);
	       
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
       
        producerThread.start();
        consumerThread.start();
		// TODO Auto-generated method stub

	}

}
