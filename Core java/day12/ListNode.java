package day12;

public class ListNode {
	public static final int val = 0;
	int value;
	ListNode next;
	ListNode(int value){
		this.value=value;
		this.next=null;
	}


	public static ListNode findMiddle(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		ListNode node1= new ListNode(1);
		ListNode node2= new ListNode(2);
		ListNode node3= new ListNode(3);
		ListNode node4= new ListNode(4);
		ListNode node5= new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		ListNode middleNode=findMiddle(node1);
		if(middleNode!=null) {
			System.out.println("The middle element is:"+middleNode.value);
			}
		else {
			System.out.println("The list is empty.");
		}
	}
		// TODO Auto-generated method stub

	}


