package LinkedList;

public class SwapPairs {
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
        ListNode answer = swapPairs(head);
        print(answer);
    }

    private static ListNode swapPairs(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int k = 0;
        while(curr!=null && k<2){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k++;
        }
        head.next = swapPairs(next);
        return prev;
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
