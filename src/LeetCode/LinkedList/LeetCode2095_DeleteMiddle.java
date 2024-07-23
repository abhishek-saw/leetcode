package LinkedList;

import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode2095_DeleteMiddle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(3);
        ListNode list13 = new ListNode(4);

        head.next = list11;
        list11.next = list12;
        list12.next = list13;
        print(head);
        ListNode answer = deleteMiddle(head);
        print(answer);
        ListNode head1 = new ListNode(1);
        ListNode list111 = new ListNode(2);
        ListNode list121 = new ListNode(3);
        ListNode list131 = new ListNode(4);

        head1.next = list111;
        list111.next = list121;
        list121.next = list131;
        print(head1);
        ListNode answer1 = deleteMiddleBetter(head1);
        print(answer1);
    }

    private static ListNode deleteMiddleBetter(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode slow = prev;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return prev.next;
    }

    private static ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        else if(head.next.next==null){
            return new ListNode(head.val);
        }
        else {
            ListNode slow = head;
            int mid = 0;
            while (slow.next != null ) {
                slow = slow.next;
                mid++;
            }
            return deleteNode(head, (mid+1)/2);
        }
    }

    private static ListNode deleteNode(ListNode head, int count) {
        if(head==null||head.next==null){
            return head;
        }
        if(count==0){
            return head.next;
        }
        head.next = deleteNode(head.next,--count);
        return head;
    }
}
