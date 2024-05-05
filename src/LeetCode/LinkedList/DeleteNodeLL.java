package LinkedList;

import static LinkedList.RotateRight.print;

public class DeleteNodeLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        print(head);
        deleteNode(node3);
        print(head);
    }

    private static void deleteNode(ListNode node) {
        while(node.next.next!=null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
    private static void deleteNodeBetter(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
