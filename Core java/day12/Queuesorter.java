package day12;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Queuesorter {
	public static void sortQueue(Queue<Integer>queue) {
		Stack<Integer>stack=new Stack<>();
		int n=queue.size();
		for (int i=0;i<n;i++) {
			int minIndex=-1;
			int minValue=Integer.MAX_VALUE;
			int currentSize=queue.size();
			for(int j=0;j<currentSize;j++) {
				int element=queue.poll();
				if(element<=minValue&& j<(currentSize-i)) {
					minValue=element;
					minIndex=j;
				}
				queue.add(element);
			}
			for(int j=0;j<currentSize;j++) {
				int element=queue.poll();
				if(j!=minIndex) {
					stack.push(element);
				}
			}
			queue.add(minValue);
			while(!stack.isEmpty()) {
				queue.add(stack.pop());
			}
		}
	}
	

	public static void main(String[] args) {
		Queue<Integer>queue=new LinkedList<>();
		queue.add(3);
		queue.add(1);
		queue.add(4);
		queue.add(2);
		queue.add(5);
		System.out.println("original queue:"+queue);
		sortQueue(queue);
		System.out.println("sorted queue:"+queue);
		// TODO Auto-generated method stub

	}

}
