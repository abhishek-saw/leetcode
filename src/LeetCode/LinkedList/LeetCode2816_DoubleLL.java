package LinkedList;


import static LinkedList.LeetCode61_RotateRight.print;


public class LeetCode2816_DoubleLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        print(head);
        print(doubleItBetter(head));
    }

    private static ListNode doubleItBetter(ListNode head) {
        if(head.val>4) {
            head = new ListNode(0, head);
        }
        ListNode newHead = head;
        while(newHead!=null){
            newHead.val = (newHead.val * 2) % 10;
            if (newHead.next != null && newHead.next.val > 4) {
                newHead.val++;
            }
            newHead = newHead.next;
        }
        return head;
    }

    private static ListNode doubleIt(ListNode head) {
        ListNode revHead = reverse(head);
//        print(revHead);
        int carry = 0;
        ListNode newHead = null;
        ListNode newTail = null;
        while (revHead!=null){
            int number = 2*revHead.val + carry;
            if(newHead==null){
                newHead = new ListNode(number%10);
                newTail = newHead;
            }
            else {
                newTail.next = new ListNode(number%10);
                newTail = newTail.next;
            }
            carry = number/10;
            revHead = revHead.next;
        }
        if(carry!=0){
            newTail.next = new ListNode(carry);
        }
        return reverse(newHead);
    }

    private static ListNode reverse(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode revHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return revHead;
    }
}
