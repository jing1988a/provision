package fb.hard;//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4


import java.util.HashMap;
import java.util.Map;




//https://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html
//https://www.cnblogs.com/lzrabbit/p/3734850.html
//https://blog.csdn.net/foye12/article/details/78647647

//public class LRUcache146 {
//    //use LinkedHashMap
//
//    Map<Integer , Integer> dict;
//    int capacity;
//
//    public LRUcache146(int capacity) {
//        this.capacity=capacity;
//        int maxSize=  (int) (capacity/0.75)+1;
//        this.dict=new LinkedHashMap(maxSize , 0.75f , true){
//            @Override
//            protected boolean removeEldestEntry(Map.Entry eldest) {
//                return this.size()>capacity;
//            }
//        };
//    }
//
//    public synchronized int get(int key) {
//        return this.dict.get(key);
//    }
//
//    public synchronized void put(int key, int value) {
//        this.dict.put(key , value);
//    }
//}

// above is greate but what if we can not use LinkedHashMap??


public class LRUcache146 {
    //use LinkedHashMap
    Map<Integer , DoubleLinkedNode> dict;
    DoubleLinkedNode head=new DoubleLinkedNode(-1   , -1);
    DoubleLinkedNode end=head;
    int capacity;
    public LRUcache146 (int capacity) {

        this.capacity=capacity;
        int maxSize=(int)(capacity/0.75)+1;
        this.dict=new HashMap<>(maxSize ,  0.75f);

    }

    public int get(int key) {
        if(!this.dict.containsKey(key)){
            return -1;
        }
        DoubleLinkedNode node=this.dict.get(key);
        moveToEnd(node);
        return node.val;

    }

    public void put(int key, int value) {
        if(!this.dict.containsKey(key)){
            if(this.dict.size()==this.capacity) {
                deleteHead();
            }
            DoubleLinkedNode node=new DoubleLinkedNode(value   , key);
            this.dict.put(key , node);
            this.end.right=node;
            node.left=this.end;
            this.end=node;

        }else{
            DoubleLinkedNode node=this.dict.get(key);
            node.val=value;
            moveToEnd(node);
        }
    }

    private void deleteHead(){
        DoubleLinkedNode node=this.head.right;
        if(this.end==node){
            this.end=node.left;

        }else{

            this.head.right=node.right;
            node.right.left=this.head;

        }
        int key=node.key;
        this.dict.remove(key);
        node=null;

    }


    private void moveToEnd(DoubleLinkedNode node){
        if(this.end==node){
            return;
        }
        DoubleLinkedNode leftNode=node.left;
        DoubleLinkedNode rightNode=node.right;
        leftNode.right=rightNode;
        rightNode.left=leftNode;
        node.left=this.end;
        this.end.right=node;
        node.right=null;
        this.end=node;
    }

    class DoubleLinkedNode{
        DoubleLinkedNode left;
        DoubleLinkedNode right;
        int val;
        int key;
        public DoubleLinkedNode(int value , int key){
            this.val=value;
            this.key=key;
        }
    }

//
//["LRUCache","put","get","put","get","get"]
//        [[1],[2,1],[2],[3,2],[2],[3]]
//
//
    static public  void main(String[]  args){
        LRUcache146 test= new LRUcache146(1);
        test.put(2 , 1);

        test.get(2 );
        test.put(3 , 2);
        test.get(2 );

        test.get(3);



    }
}
