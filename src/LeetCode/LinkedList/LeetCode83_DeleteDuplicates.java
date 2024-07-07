package LinkedList;

import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode83_DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode list11 = new ListNode(1);
        ListNode list12 = new ListNode(2);
        ListNode list13 = new ListNode(3);
        ListNode list14 = new ListNode(3);
        head.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list14;
        print(head);
        print(deleteDuplicates(head));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        while (temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }
}
