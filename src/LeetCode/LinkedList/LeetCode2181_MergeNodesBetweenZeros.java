package LinkedList;

import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode2181_MergeNodesBetweenZeros {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode list11 = new ListNode(3);
        ListNode list12 = new ListNode(1);
        ListNode list13 = new ListNode(0);
        ListNode list14 = new ListNode(4);
        ListNode list15 = new ListNode(5);
        ListNode list16 = new ListNode(2);
        ListNode list17 = new ListNode(0);
        head1.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list14;
        list14.next = list15;
        list15.next = list16;
        list16.next = list17;
        print(head1);
        ListNode answer1 = mergeNodes(head1);
        print(answer1);
        ListNode head = new ListNode(0);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(0);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(0);
        ListNode list5 = new ListNode(2);
        ListNode list6 = new ListNode(2);
        ListNode list7 = new ListNode(0);
        head.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        print(head);
        ListNode answer = mergeNodes(head);
        print(answer);
    }

    private static ListNode mergeNodes(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode newHead =null;
        ListNode newTail = null;
        int sum = 0;
        while (head.val==0){
            head= head.next;
        }
        while (head!=null){
            if(head.val==0){
                if(newHead==null){
                    newHead = new ListNode(sum);
                    newTail = new  ListNode(sum);
                    newHead.next = newTail;
                }
                else {
                    newTail.next = new ListNode(sum);;
                    newTail = newTail.next;
                }
                sum = 0;
            }
            sum+= head.val;
            head = head.next;
        }
        return newHead.next;
    }
}
