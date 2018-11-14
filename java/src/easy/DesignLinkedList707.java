package easy;
//Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
//
//        Implement these functions in your linked list class:
//
//        get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
//        addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
//        addAtTail(val) : Append a node of value val to the last element of the linked list.
//        addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
//        deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
//        Example:
//
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
//        linkedList.get(1);            // returns 2
//        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
//        linkedList.get(1);            // returns 3
//        Note:
//
//        All values will be in the range of [1, 1000].
//        The number of operations will be in the range of [1, 1000].
//        Please do not use the built-in LinkedList library.
public class DesignLinkedList707 {
    Node preHead=new Node(-1);
    Node end=preHead;
    /** Initialize your data structure here. */
    public DesignLinkedList707() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(this.preHead.next==null){return -1;}
        Node cur=this.preHead.next;
        int i=0;
        while(cur!=null && i<index){
            cur=cur.next;
            i++;
        }
        if(cur==null){return -1;}
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(this.preHead.next==null){
            Node temp=new Node(val);
            this.preHead.next=temp;
            this.end=temp;
            return;
        }
        Node right=this.preHead.next;
        Node temp=new Node(val);
        temp.next=right;
        this.preHead.next=temp;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node temp=new Node(val);
        this.end.next=temp;
        this.end=temp;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0){return;}
        Node pre=this.preHead;
        int i=0;
        while(pre!=null && i<index){
            pre=pre.next;
            i++;
        }
        if(pre==null){return;}
        pre.next=new Node(val);
        if(pre==this.end){
            this.end=pre.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0){return;}
        Node pre=this.preHead;
        int i=0;
        while(pre!=null && i<index){
            pre=pre.next;
            i++;
        }
        if(pre==null || pre.next==null){return;}
        Node toDelete=pre.next;
        if(toDelete==this.end){
            this.end=pre;
        }
        pre.next=toDelete.next;
        toDelete=null;

    }
    class Node{
        int val;
        Node next;
        public Node(int v){
            this.val=v;
        }
    }



    static public void main(String[] atgs){
        DesignLinkedList707 test=new DesignLinkedList707();
        test.addAtHead(1);
        test.addAtTail(1);
        test.addAtIndex(1 , 2);
        test.get(1);
        test.deleteAtIndex(1);
        test.get(1);
    }
}
