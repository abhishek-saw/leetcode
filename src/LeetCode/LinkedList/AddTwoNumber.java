package LinkedList;

public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;
        print(l1);
        print(l2);
        ListNode answer = addTwoNumbers(l1,l2);
        print(answer);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = null;
        ListNode answerTail = null;
        int sum;
        int carry = 0;
        while(l1!=null || l2!=null ) {
            sum = carry;
            carry =0;
            if(l1!=null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            if(sum>9){
                carry=sum/10;
            }
            if(answer==null){
                answer = new ListNode(sum%10);
                answerTail = answer;
            }
            else {
                answerTail.next = new ListNode(sum % 10);
                answerTail = answerTail.next;
            }
        }
        if(carry!=0){
            answerTail.next = new ListNode(carry);
        }
        return answer;
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
