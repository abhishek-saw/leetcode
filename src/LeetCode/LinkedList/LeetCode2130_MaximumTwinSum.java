package LinkedList;

import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode2130_MaximumTwinSum {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode list11 = new ListNode(4);
        ListNode list12 = new ListNode(2);
        ListNode list13 = new ListNode(1);

        head.next = list11;
        list11.next = list12;
        list12.next = list13;
        print(head);
        ListNode head1 = new ListNode(4);
        ListNode list111 = new ListNode(2);
        ListNode list121 = new ListNode(2);
        ListNode list131 = new ListNode(3);

        head1.next = list111;
        list111.next = list121;
        list121.next = list131;
        print(head1);

        ListNode head11 = new ListNode(1);
        ListNode list1111 = new ListNode(100000);
        head11.next = list1111;
        print(head11);

        System.out.println(pairSum(head));
        System.out.println(pairSum(head1));
        System.out.println(pairSum(head11));

    }

    private static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode toReverse = reverse(slow.next);
        int max = 0;
        while (toReverse!=null && head!=null){
            max = Math.max(max,toReverse.val+head.val);
            toReverse = toReverse.next;
            head = head.next;
        }
        return max;
    }

    private static ListNode reverse(ListNode head) {
        if(head == null|| head.next==null){
            return head;
        }
        ListNode reversed = reverse(head.next);
        ListNode node = head.next;
        node.next = head;
        head.next = null;
        return reversed;
    }
}