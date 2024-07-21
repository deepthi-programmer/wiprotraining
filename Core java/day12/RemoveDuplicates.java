package day12;
public class RemoveDuplicates{
    public static ListNode removeDuplicates(ListNode head) {
                    ListNode current = head;

            while (current != null && current.next != null) {
                
                if (current.val == current.next.val) {
                    
                    current.next = current.next.next;
                } else {
                    
                    current = current.next;
                }
            }

            
            return head;
        }

        public static void printList(ListNode head) {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            
            ListNode head = new ListNode(1);
            head.next = new ListNode(1);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(3);
            head.next.next.next.next = new ListNode(3);

            System.out.println("Original linked list:");
            printList(head);
           
            head = removeDuplicates(head);

            System.out.println("Linked list after removing duplicates:");
            printList(head);
        }
    

}





