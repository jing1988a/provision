package easy;
//Design and implement a TwoSum class. It should support the following operations: add and find.
//
//        add - Add the number to an internal data structure.
//        find - Find if there exists any pair of numbers which sum is equal to the value.
//
//        Example 1:
//
//        add(1); add(3); add(5);
//        find(4) -> true
//        find(7) -> false
//        Example 2:
//
//        add(3); add(1); add(2);
//        find(3) -> true
//        find(6) -> false

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDatastructuredesign170 {
    /** Initialize your data structure here. */
    Map<Integer , Integer> store=new HashMap<>();
    public TwoSumIIIDatastructuredesign170() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!this.store.containsKey(number)){
            this.store.put(number , 1);
        }else{
            this.store.put(number  , this.store.get(number)+1);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer a:this.store.keySet()){
            Integer b=value-a;
            if(this.store.containsKey(b)){
                if(  (a.equals(b) && this.store.get(a)>1 ) ||   (!a.equals(b)) ){
                    return true;
                }
            }
        }
        return false;
    }
}
