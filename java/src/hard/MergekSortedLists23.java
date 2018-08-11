package hard;//
//Merge k sorted linked lists and return it as one sorted list.Analyze and describe its complexity.
//
//        Example:
//
//        Input:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        Output:1->1->2->3->4->4->5->6

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<List> pq=new PriorityQueue<>(10 ,(x , y)->(int)x.get(0)-(int)y.get(0));
        for(ListNode n:lists){
            if(n!=null) {
                int val = n.val;
                List temp = new ArrayList();
                temp.add(val);
                temp.add(n);
                pq.add(temp);
            }

        }
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(!pq.isEmpty()){
            ListNode n=(ListNode)pq.poll().get(1);
            cur.next=n;
            if(n.next!=null){
                List temp=new ArrayList();
                temp.add(n.next.val);
                temp.add(n.next);
                pq.add(temp);
            }
            cur=cur.next;
        }
        return dummy.next;
    }



//    [[1,4,5],[1,3,4],[2,6]]
//    Output:
//            [1,1,2,3,4,6]
//    Expected:
//            [1,1,2,3,4,4,5,6]

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
