package day12;
import java.util.Stack;
public class StackSorter {
public static void sortStack(Stack<Integer>stack) {
	Stack<Integer>tempStack=new Stack<>();
	while(!stack.isEmpty()) {
		int current=stack.pop();
		while(!tempStack.isEmpty()&&tempStack.peek()>current) {
			stack.push(tempStack.pop());
		}
		tempStack.push(current);
	}
	while(!tempStack.isEmpty()) {
		stack.push(tempStack.pop());
	}
}
	public static void main(String[] args) {
		Stack<Integer>stack=new Stack<>();
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(2);
		stack.push(5);
		System.out.println("Original stack:"+stack);
		sortStack(stack);
		System.out.println("Sorted stack:"+stack);
		// TODO Auto-generated method stub

	}

}
