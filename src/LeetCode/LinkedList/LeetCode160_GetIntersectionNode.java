package LinkedList;

import java.util.List;

import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode160_GetIntersectionNode {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(8);
        ListNode list3 = new ListNode(4);
        ListNode list4 = new ListNode(5);

        head1.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        print(head1);

        ListNode head2 = new ListNode(5);
        ListNode list11 = new ListNode(6);
        ListNode list12 = new ListNode(1);
        head2.next = list11;
        list11.next = list12;
        list12.next = list2;
        print(head2);
        print(getIntersectionNode(head1,head2));
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1!=temp2){
            if(temp1==null) {
                temp1 = headB;
            }
            else {
//                System.out.print("temp1 "+temp1.val);
                temp1=temp1.next;
            }
            if(temp2==null) {
                temp2 = headA;
            }
            else {
//                System.out.print(" temp2 "+temp2.val);
                temp2=temp2.next;
            }
            System.out.println();
        }
        return temp1;
    }
}
