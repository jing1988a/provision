public class ReverseLL206 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=null;
        ListNode temp=null;
        ListNode cur=head;
        while (cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;

    }
}
