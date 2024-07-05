package LinkedList;

import Xtra.MaxSlidingWindow;

import java.util.Arrays;

import static LinkedList.LeetCode61_RotateRight.print;

public class LeetCode2058_NodesBetweenCriticalPoints {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        print(head);
        ListNode head1 = new ListNode(5);
        ListNode list1 = new ListNode(3);
        ListNode list2 = new ListNode(1);
        ListNode list3 = new ListNode(2);
        ListNode list4 = new ListNode(5);
        ListNode list5 = new ListNode(1);
        ListNode list6 = new ListNode(2);
        head1.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        print(head1);
//        6,8,4,1,9,6,6,10,6
        ListNode head11 = new ListNode(6);
        ListNode list11 = new ListNode(8);
        ListNode list21 = new ListNode(4);
        ListNode list31 = new ListNode(1);
        ListNode list41 = new ListNode(9);
        ListNode list51 = new ListNode(6);
        ListNode list61 = new ListNode(6);
        ListNode list71 = new ListNode(10);
        ListNode list81 = new ListNode(6);
        head11.next = list11;
        list11.next = list21;
        list21.next = list31;
        list31.next = list41;
        list41.next = list51;
        list51.next = list61;
        list61.next = list71;
        list71.next = list81;
        print(head11);
        ListNode head12 = new ListNode(2);
        ListNode list12 = new ListNode(3);
        ListNode list22 = new ListNode(3);
        ListNode list32 = new ListNode(2);
        head12.next = list12;
        list12.next = list22;
        list22.next = list32;
        print(head12);
//        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head1)));
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head11)));
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head12)));
    }

    private static int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] answer = new int[]{-1,-1};
        if(head==null || head.next==null || head.next.next==null){
            return answer;
        }
        ListNode temp = head;
        int count = 2;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int secondMax = 0;
        while (temp.next.next!=null){
            int prev = temp.val;
            int curr = temp.next.val;
            int next = temp.next.next.val;
            if((prev<curr &&curr>next) ||( prev>curr &&curr<next)){
                min = Math.min(min,count);
                secondMax = max;
                max = Math.max(max,count);

                maximum = Math.max(max-min,maximum);
                if(secondMax!=Integer.MIN_VALUE){
                    minimum =  Math.min(max-secondMax,minimum);
                }
            }
            count++;
            temp = temp.next;
        }
        if(secondMax==0 || minimum==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[]{minimum,maximum};
    }
}
