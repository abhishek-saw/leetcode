package LinkedList;

public class ReverseKGroup {
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
        int k = 3;
        ListNode answer = reverseKGroup(head, k);
        print(answer);

    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <2 || head == null ||head.next==null) {
            return head;
        }
        int checkLength = length(head);
        if(checkLength<k){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int temp = 0;
        while (curr != null && temp < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                temp++;
        }
        head.next = reverseKGroup(next, k);
        return prev;
    }

    private static int length(ListNode head) {
        if(head==null){
            return 0;
        }
        return  1 +  length(head.next);
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
