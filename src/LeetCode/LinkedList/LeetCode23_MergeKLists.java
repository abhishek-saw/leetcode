package LinkedList;

public class LeetCode23_MergeKLists {
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
        ListNode list3 = new ListNode(1);
        ListNode list31 = new ListNode(2);
        ListNode list32 = new ListNode(4);
        list3.next = list31;
        list31.next = list32;
        print(list1);
        print(list2);
        print(list3);
        ListNode[] lists ={list1,list2,list3};
        ListNode answer = mergeKLists(lists);
        print(answer);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return mergeTwoListsHelper(lists,0,lists.length-1);
//        ListNode answer = new ListNode(-1);
//        for (ListNode list : lists) {
//            answer.next = mergeTwoLists(answer.next, list);
//        }
//        return answer.next;
    }

    private static ListNode mergeTwoListsHelper(ListNode[] lists, int start, int end) {
        if(start>end){
            return null;
        }
        if(start==end){
            return lists[start];
        }
        int mid = start + (end-start)/2;
        ListNode left = mergeTwoListsHelper(lists,start,mid);
        ListNode right = mergeTwoListsHelper(lists,mid+1,end);
        return mergeTwoLists(left,right);
    }
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                tail.next = temp1;
                temp1 = temp1.next;
            }
            else {
               tail.next = temp2;
               temp2 = temp2.next;
            }
            tail = tail.next;
        }
        if(temp1!=null){
            tail.next = temp1;
        }
        if(temp2!=null){
            tail.next = temp2;
        }
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
