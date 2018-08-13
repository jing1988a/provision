package medium;

//
//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//        You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//        Example 1:
//
//        Given 1->2->3->4, reorder it to 1->4->2->3.
//        Example 2:
//
//        Given 1->2->3->4->5, reorder it to 1->5->2->4->3.




public class ReorderList143 {
    public void reorderList(ListNode head) {
        if(head==null){return;}
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode rRoot=slow.next;
        slow.next=null;
        ListNode newRroot=reverse(rRoot);
        combine(head , newRroot);

    }

    private ListNode reverse(ListNode root){
        ListNode pre=null;
        while(root!=null){
            ListNode temp=root.next;
            root.next=pre;
            pre=root;
            root=temp;
        }
        return pre;
    }

    private void combine(ListNode l , ListNode r){
        ListNode a=l;
        ListNode b=r;
        while(b!=null){
            ListNode aNext=a.next;
            ListNode bNext=b.next;
            a.next=b;
            b.next=aNext;
            a=aNext;
            b=bNext;
        }
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }


}
