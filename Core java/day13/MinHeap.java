package day13;

public class MinHeap {
	 private int[] heap;
	    private int size;
	    private int capacity;

	    public MinHeap(int capacity) {
	        this.capacity = capacity;
	        this.size = 0;
	        heap = new int[capacity];
	    }
	    public void insert(int value) {
	        if (size == capacity) {
	            System.out.println("Heap is full. Cannot insert more elements.");
	            return;
	        }
	       
	        size++;
	        int index = size - 1;
	        heap[index] = value;
	       
	        // Fix the min-heap property
	        heapifyUp(index);
	    }
	    public int deleteMin() {
	        if (size == 0) {
	            System.out.println("Heap is empty. Cannot delete minimum element.");
	            return -1;
	        }

	        int minValue = heap[0];
	        heap[0] = heap[size - 1];
	        size--;

	        // Fix the min-heap property
	        heapifyDown(0);

	        return minValue;
	    }
	    public int getMin() {
	        if (size == 0) {
	            System.out.println("Heap is empty. No minimum element.");
	            return -1;
	        }
	        return heap[0];
	    }
	    private void heapifyUp(int index) {
	        int parentIndex = (index - 1) / 2;
	        while (index > 0 && heap[parentIndex] > heap[index]) {
	            swap(parentIndex, index);
	            index = parentIndex;
	            parentIndex = (index - 1) / 2;
	        }
	    }
	    private void heapifyDown(int index) {
	        int leftChildIndex = 2 * index + 1;
	        int rightChildIndex = 2 * index + 2;
	        int smallest = index;

	        if (leftChildIndex < size && heap[leftChildIndex] < heap[smallest]) {
	            smallest = leftChildIndex;
	        }

	        if (rightChildIndex < size && heap[rightChildIndex] < heap[smallest]) {
	            smallest = rightChildIndex;
	        }

	        if (smallest != index) {
	            swap(smallest, index);
	            heapifyDown(smallest);
	        }
	    }
	    private void swap(int i, int j) {
	        int temp = heap[i];
	        heap[i] = heap[j];
	        heap[j] = temp;
	    }

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(10);
	 minHeap.insert(5); 
       minHeap.insert(3);
	 minHeap.insert(7);
	 minHeap.insert(2);

	 System.out.println("Minimum element: " + minHeap.getMin()); // Output: 2

 minHeap.deleteMin();
 System.out.println("Minimum element after deletion: " + minHeap.getMin());
		// TODO Auto-generated method stub

	}

}
