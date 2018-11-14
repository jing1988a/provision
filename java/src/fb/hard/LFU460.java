package fb.hard;//Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LFUCache cache = new LFUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.get(3);       // returns 3.
//        cache.put(4, 4);    // evicts key 1.
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4


import java.util.HashMap;
import java.util.Map;

public class LFU460 {


//    这题 还是 doubleLinkedList +HashMap O(1) O(1)...
//    下面这做法O(1)  O(N)   傻逼做法别写了 有空写上面那个吧。。


    int capacity;
    Map<Integer , Integer> keyValue;
    Map<Integer , Integer> keyFrequent;

    public LFU460(int capacity) {
        this.capacity=capacity;
        keyValue=new HashMap<>();
        keyFrequent=new HashMap<>();

    }

    public int get(int key) {
        if(!this.keyValue.containsKey(key)){
            return -1;
        }
        this.keyFrequent.put(key , this.keyFrequent.get(key)+1);
        return this.keyValue.get(key);
    }

    public void put(int key, int value) {
        if(this.capacity==0){return ;}

        if(!this.keyValue.containsKey(key)){
            if(this.keyValue.size()==this.capacity){
                //remove least frequent
                int minF=Integer.MAX_VALUE;
                int minKey=0;
                for(int k: this.keyFrequent.keySet()){
                    if(minF>this.keyFrequent.get(k)){
                        minF=this.keyFrequent.get(k);
                        minKey=k;
                    }

                }
                this.keyFrequent.remove(minKey);
                this.keyValue.remove(minKey);
            }
            this.keyFrequent.put(key , 1);
            this.keyValue.put(key , value);

        }else{
            this.keyFrequent.put(key , this.keyFrequent.get(key)+1);
            this.keyValue.put(key , value);
        }
    }
}