//Design a data structure that supports all following operations in average O(1) time.
//
//        insert(val): Inserts an item val to the set if not already present.
//        remove(val): Removes an item val from the set if present.
//        getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
//        Example:
//
//// Init an empty set.
//        RandomizedSet randomSet = new RandomizedSet();
//
//// Inserts 1 to the set. Returns true as 1 was inserted successfully.
//        randomSet.insert(1);
//
//// Returns false as 2 does not exist in the set.
//        randomSet.remove(2);
//
//// Inserts 2 to the set, returns true. Set now contains [1,2].
//        randomSet.insert(2);
//
//// getRandom should return either 1 or 2 randomly.
//        randomSet.getRandom();
//
//// Removes 1 from the set, returns true. Set now contains [2].
//        randomSet.remove(1);
//
//// 2 was already in the set, so return false.
//        randomSet.insert(2);
//
//// Since 2 is the only number in the set, getRandom always return 2.
//        randomSet.getRandom();


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsertDeleteGetRandom380 {

    HashMap<Integer, Integer> valueIdx = new HashMap<>();
    List<Integer> store = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom380() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (this.valueIdx.containsKey(val)) {
            return false;
        }
        this.store.add(val);
        this.valueIdx.put(val, this.store.size()-1);
        return true;

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!this.valueIdx.containsKey(val)) {
            return false;
        }

        int valIdx=this.valueIdx.get(val);
        int lastVal=this.store.get(this.store.size()-1);
        this.store.set(valIdx , lastVal);
        this.valueIdx.put(lastVal , valIdx);
        this.valueIdx.remove(val);
        this.store.remove(this.store.size()-1);
        return true;

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return this.store.get((int) (Math.random() * this.store.size()));
    }


    static public void main(String[] args){
//["RandomizedSet","insert","remove","remove","insert","getRandom","remove"]
//[[],[3],[3],[0],[3],[],[0]]
        InsertDeleteGetRandom380 test=new InsertDeleteGetRandom380();
        test.insert(3);
        test.remove(3);
        test.remove(0);
        test.insert(3);
        test.getRandom();
        test.remove(0);
    }
}
