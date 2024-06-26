package LinkedList;

public class LeetCode206_ReverseList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(3);
        ListNode list13 = new ListNode(4);
        ListNode list14 = new ListNode(5);

        head.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list14;
        print(head);
        ListNode answer = reverseList(head);
        print(answer);
    }

    private static ListNode reverseList(ListNode head) {
        if(head==null ||head.next ==null){
            return head;
        }
        ListNode reverseHead = reverseList(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return reverseHead;
    }

    private static void print(ListNode l){
        if(l==null){
            System.out.println();
            return;
        }
        System.out.print(l.val + " ") ;
        print(l.next);
    }
}
