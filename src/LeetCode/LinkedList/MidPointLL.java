package LinkedList;

import static LinkedList.RotateRight.print;

public class MidPointLL {
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
        ListNode answer = middleNode(head);
        print(answer);
    }

    private static ListNode middleNode(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head.next;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
}
