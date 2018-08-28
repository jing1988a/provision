package fb.hard;
//Design a data structure that supports all following operations in average O(1) time.
//
//        Note: Duplicate elements are allowed.
//        insert(val): Inserts an item val to the collection.
//        remove(val): Removes an item val from the collection if present.
//        getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
//        Example:
//
//// Init an empty collection.
//        RandomizedCollection collection = new RandomizedCollection();
//
//// Inserts 1 to the collection. Returns true as the collection did not contain 1.
//        collection.insert(1);
//
//// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
//        collection.insert(1);
//
//// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
//        collection.insert(2);
//
//// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
//        collection.getRandom();
//
//// Removes 1 from the collection, returns true. Collection now contains [1,2].
//        collection.remove(1);
//
//// getRandom should return 1 and 2 both equally likely.
//        collection.getRandom();


import java.util.*;

public class InsertDeleteGetRandomO1Duplicatesallowed381 {
    Map<Integer  , TreeSet<Integer>> valIdx=new HashMap<>();// 用 doubleLinked list 会比 treeSet 好  treeSet 是O（logN）   DL 是O(1)
    List<Integer> storage=new ArrayList<>();
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1Duplicatesallowed381() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        this.storage.add(val);
        int idx=this.storage.size()-1;
        if(this.valIdx.containsKey(val)){
            this.valIdx.get(val).add(idx);
            return false;
        }else{
            TreeSet<Integer> temp=new TreeSet<>();
            temp.add(idx);
            this.valIdx.put(val , temp);
            return true;
        }

    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!this.valIdx.containsKey(val)){return false;}
        int lastIdx=this.storage.size()-1;
        int lastVal=this.storage.get(lastIdx);
        if(lastVal==val){
            this.storage.remove(lastIdx);
            this.valIdx.get(val).remove(lastIdx);
            if(this.valIdx.get(val).isEmpty()){
                this.valIdx.remove(val);
            }
            return true;
        }
        int candidateIdx=this.valIdx.get(val).last();
//        add(int index, E element)

//        Inserts the specified element at the specified position in this list (optional operation).
//
//        set(int index, E element) Replaces the element at the specified position in this list with the specified element (optional operation).
//        所以 ADD 会插入 ， set 才是replace
        this.storage.set(candidateIdx , lastVal);
        this.valIdx.get(lastVal).remove(lastIdx);
        this.valIdx.get(lastVal).add(candidateIdx);
        this.valIdx.get(val).remove(candidateIdx);
        if(this.valIdx.get(val).isEmpty()){
            this.valIdx.remove(val);
        }
        this.storage.remove(lastIdx);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return this.storage.get((int)(Math.random()*this.storage.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
