package hard;//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//        k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//        Example:
//
//        Given this linked list: 1->2->3->4->5
//
//        For k = 2, you should return: 2->1->4->3->5
//
//        For k = 3, you should return: 3->2->1->4->5
//
//        Note:
//
//        Only constant extra memory is allowed.
//        You may not alter the values in the list's nodes, only nodes itself may be changed.

public class ReverseNodeskGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode start=preHead;
        while(start!=null){
            ListNode last=start;
            for(int i=0 ; i<k ; i++){
                last=last.next;
                if(last==null){
                    return preHead.next;
                }
            }
            start=doReverse(start  ,  last);
        }
        return preHead.next;
    }


    private  ListNode doReverse(ListNode preStart  , ListNode last){
        ListNode start=preStart.next;
        while (preStart.next!=last){
            ListNode temp=start.next;
            start.next=temp.next;
            temp.next=preStart.next;
            preStart.next=temp;
        }
        return start;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
