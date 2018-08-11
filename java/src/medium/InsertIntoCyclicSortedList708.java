package medium;//
//Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.
//
//        If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.
//
//        If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.
//
//        The following example may help you understand the problem better:
//
//
//
//
//
//        In the figure above, there is a cyclic sorted list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list.
//
//
//
//
//
//
//
//
//
//        The new node should insert between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.

public class InsertIntoCyclicSortedList708 {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node n= new Node();
            n.val=insertVal;
            n.next=n;
            return n;
        }
        //find Max and break it to a regular linked list
        Node pre=head;
        Node cur=head.next;
        while(pre.val<=cur.val && cur!=head){
            pre=cur;
            cur=cur.next;
        }
        pre.next=null;


        //insert
        Node dummy=new Node();
        dummy.next=cur;
        pre=dummy;
        while(cur!=null && insertVal>cur.val){
            pre=cur;
            cur=cur.next;
        }
        Node n=new Node(insertVal , cur);
        pre.next=n;


        //find tail and add it
        pre=dummy;
        cur=dummy.next;
        while(cur!=null){
            pre=cur;
            cur=cur.next;
        }
        pre.next=dummy.next;


        return head;
    }


    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

}
