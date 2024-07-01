package LinkedList;


import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode148_SortLL {
    public static void main(String[] args) {

        ListNode head = new ListNode(-1);
        ListNode list11 = new ListNode(5);
        ListNode list12 = new ListNode(3);
        ListNode list13 = new ListNode(4);
        ListNode list14 = new ListNode(0);
        head.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list14;
        print(head);
        print(sortList(head));
    }

    private static ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode h1 = head;
        ListNode t2 = h1;
        ListNode h2 = midpoint(head).next;
        while (t2.next!=h2){
            t2 = t2.next;
        }
        t2.next= null;
        ListNode sort1 = mergeSort(h1);
        ListNode sort2 = mergeSort(h2);
        return mergeTwoList(sort1,sort2);
    }

    static ListNode mergeTwoList(ListNode h1, ListNode h2) {
        ListNode newHead;
        ListNode newTail;
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        if(h1.val<=h2.val){
            newHead = h1;
            h1 = h1.next;
        }
        else{
            newHead = h2;
            h2 = h2.next;
        }
        newTail = newHead;
        while (h1!=null && h2!=null){
            if(h1.val<=h2.val){
                newTail.next = h1;
                newTail = h1;
                h1 = h1.next;
            }
            else {
                newTail.next = h2;
                newTail = h2;
                h2 = h2.next;
            }
        }
        if(h1!=null){
            newTail.next= h1;
        }
        if(h2!=null){
            newTail.next= h2;
        }

        return newHead;
    }
    public static ListNode midpoint(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
