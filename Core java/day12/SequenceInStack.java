package day12;
import java.util.Stack;
public class SequenceInStack {
public static boolean isSequenceInStack(Stack<Integer>stack, int[] sequence) {
	Stack<Integer>tempStack=new Stack<>();
	tempStack.addAll(stack);
	int seqIndex=0;
	while(!tempStack.isEmpty()&& seqIndex<sequence.length) {
		int currentElement=tempStack.pop();
		if(currentElement==sequence[seqIndex]) {
			seqIndex++;
		}else {
			seqIndex=0;
		}
		}
		return seqIndex==sequence.length;
	}
	public static void main(String[] args) {
		Stack<Integer>Stack=new Stack<>();
		Stack.push(3);
		Stack.push(1);
	    Stack.push(4);
		Stack.push(2);
		Stack.push(5);
		
		int[] sequence= {4,2,5};
		boolean result=isSequenceInStack(Stack,sequence);
		System.out.println("Is the sequence present in the stack?"+result);
		System.out.println("Stack after operation:"+Stack);
		// TODO Auto-generated method stub

	}

}
