package day12;


public class MergeSotedLists {
	public static ListNode mergerTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy=new ListNode(-1);
		ListNode current=dummy;
		while(l1 !=null && l2!=null) {
			if(l1.val<=l2.val) {
				current.next=l1;
				l1=l1.next;
			}
			current=current.next;
		}
		if(l1!=null) {
			current.next=l1;
		}
		else {
			current.next=l2;
		}
		return dummy.next;
	}
public static void printList(ListNode head) {
	ListNode current=head;
	while(current!=null) {
		System.out.println(current.val+"");
		current=current.next;
	}
	System.out.println();
}
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(3);
		l1.next.next=new ListNode(5);
		ListNode l2=new ListNode(2);
		l2.next=new ListNode(4);
		l2.next.next=new ListNode(6);
		System.out.println("First list:");
		printList(l1);
		System.out.println("Second list:");
		ListNode mergedList=mergerTwoLists(l1,l2);
		System.out.println("Merge list:");
		printList(mergedList);
		// TODO Auto-generated method stub

	}

}
