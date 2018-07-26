package easy;//Given a singly linked list, determine if it is a palindrome.
//
//        Example 1:
//
//        Input: 1->2
//        Output: false
//        Example 2:
//
//        Input: 1->2->2->1
//        Output: true
//        Follow up:
//        Could you do it in O(n) time and O(1) space?

import java.util.Stack;

//Arrays.deepEquals(outarr1, outarr2))
//Arrays.equals(outarr1, outarr2))
public class PalinLInkedList234 {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode cur=head;
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            if(cur.val!=stack.pop()){
                return false;
            }
            cur=cur.next;
        }
        return true;
    }
//    Java does not support multi-value returns. Return an array of values.
//
//    // Function code
//    public static int[] something(){
//        int number1 = 1;
//        int number2 = 2;
//        return new int[] {number1, number2};
//    }
//
//    // Main class code
//    public static void main(String[] args) {
//        int result[] = something();
//        System.out.println(result[0] + result[1]);
//    }
    public boolean isPalindrome2(ListNode head) {
        ListNode[] temp=new ListNode[2];
        if(head==null){return true;}
        temp=breakList(head);
        ListNode lHead=temp[0];
        ListNode rHead=temp[1];
        ListNode rReverseHead=reverseList(rHead);
        return compare(lHead , rReverseHead);
    }
    private ListNode[] breakList(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode l=head;
        ListNode r=slow.next;
        slow.next=null;
        return new ListNode[] {l , r};
    }
    private ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
    private  boolean compare(ListNode lHead , ListNode rHead){
        ListNode rCur=rHead;
        ListNode lCur=lHead;
        while(rCur!=null){
            if(lCur.val!=rCur.val){
                return false;
            }
            rCur=rCur.next;
            lCur=lCur.next;
        }
        return true;
    }
}
