package LinkedList;


public class RotateRight {
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
        int k = 2;
        ListNode answer = rotateRight(head,k);
        print(answer);
    }

    private static ListNode rotateRight(ListNode head, int k) {
        int height = heightOfLL(head);
        k = k %height;
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int count = height - k;
        ListNode newHead = null;
        ListNode start = head;
        ListNode end = start;
        ListNode temp = head;
        while (temp != null) {
            if (count == 1) {
                newHead = temp.next;
                start.next = null;
            }
            start = start.next;
            temp = temp.next;
            count--;
        }
        ListNode newTail = null;
        if (newHead != null) {
            newTail = newHead;
            while (newTail.next != null) {
                newTail = newTail.next;
            }
            newTail.next = end;
        }
        return newHead;
    }

    private static int heightOfLL(ListNode head) {
        if(head==null){
            return 0;
        }
        return 1 + heightOfLL(head.next);
    }

    public static void print(ListNode l){
        if(l==null){
            System.out.println();
            return;
        }
        System.out.print(l.val + " ") ;
        print(l.next);
    }
}
