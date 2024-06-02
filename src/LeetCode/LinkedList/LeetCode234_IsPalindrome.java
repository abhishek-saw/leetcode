package LinkedList;

public class LeetCode234_IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(3);
        ListNode list13 = new ListNode(3);
        ListNode list14 = new ListNode(2);
        ListNode list15 = new ListNode(1);


        head.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list14;
        list14.next = list15;
        print(head);
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next ==null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        print(slow);
        ListNode curr = slow;
        ListNode prev = null;
        ListNode next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        print(prev);
        while(prev.next!=null){
            if(prev.val!=head.val){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
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
