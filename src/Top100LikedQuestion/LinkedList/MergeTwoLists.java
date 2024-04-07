package LinkedList;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(4);
        list1.next = list11;
        list11.next = list12;
        ListNode list2 = new ListNode(1);
        ListNode list21 = new ListNode(3);
        ListNode list22 = new ListNode(4);
        list2.next = list21;
        list21.next = list22;
        print(list1);
        print(list2);
        ListNode answer = mergeTwoLists(list1,list2);
        print(answer);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        if(list1==null){
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1==null?list2 :list1;
        return head.next;
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
