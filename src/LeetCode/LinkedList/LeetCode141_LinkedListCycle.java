package LinkedList;

import java.util.HashMap;

import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode141_LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(0);
        ListNode list13 = new ListNode(-4);
        head.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list11;
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}