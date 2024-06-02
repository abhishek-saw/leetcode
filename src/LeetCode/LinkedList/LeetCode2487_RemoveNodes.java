package LinkedList;


import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode2487_RemoveNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(99999);
        ListNode node1 = new ListNode(99998);
        ListNode node2 = new ListNode(99997);
        ListNode node3 = new ListNode(99996);
        ListNode node4 = new ListNode(100000);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        print(head);
        print(removeNodes(head));
    }

    private static ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode revHead = reverse(head);
        print(revHead);
        ListNode newHead = null;
        ListNode newTail = null;
        int data = Integer.MIN_VALUE;
        while (revHead != null) {
            if (data < revHead.val) {
                if (newHead == null) {
                    newHead = new ListNode(revHead.val);
                    newTail = newHead;
                } else {
                    newTail.next = new ListNode(revHead.val);
                    newTail = newTail.next;

                }
                data = revHead.val;
            }
            revHead = revHead.next;
        }

        return reverse(newHead);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode revHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return revHead;
    }

    private static ListNode removeNodesBetter(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        int max = -1;
        while (head != null) {
            if (head.val >= max) {
                max = head.val;
                dummy.next = head;
                dummy = dummy.next;
            }
            head = head.next;
        }
        dummy.next = null;
        return reverse(temp.next);


    }
}