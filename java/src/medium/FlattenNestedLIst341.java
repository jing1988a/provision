package medium;//Given a nested list of integers, implement an iterator to flatten it.
//
//        Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
//        Example 1:
//        Given the list [[1,1],2,[1,1]],
//
//        By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
//
//        Example 2:
//        Given the list [1,[4,[6]]],
//
//        By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


public class FlattenNestedLIst341 implements Iterator<Integer> {
    List<Integer> flattenedList=new ArrayList<>();
    int idx;
    int l;
    public FlattenNestedLIst341(List<NestedInteger> nestedList) {

        doFlatten(nestedList);
        this.idx = 0;
        this.l = flattenedList.size();

    }
    private void doFlatten(List<NestedInteger> nestedList){
        for(NestedInteger NI: nestedList ){
            if(NI.isInteger()==true){
                this.flattenedList.add(NI.getInteger());
            }else{
                doFlatten(NI.getList());
            }
        }
    }

    @Override
    public Integer next() {
        int ans=this.flattenedList.get(this.idx);
        this.idx++;
        return ans;
    }

    @Override
    public boolean hasNext() {
        if(this.idx==this.l){return false;}
        return true;
    }
}
