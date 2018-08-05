package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Given two 1d vectors, implement an iterator to return their elements alternately.
//
//        Example:
//
//        Input:
//        v1 = [1,2]
//        v2 = [3,4,5,6]
//
//        Output: [1,3,2,4,5,6]
//
//        Explanation: By calling next repeatedly until hasNext returns false,
//        the order of elements returned by next should be: [1,3,2,4,5,6].
//        Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
//
//        Clarification for the follow up question:
//        The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:
//
//        Input:
//        [1,2,3]
//        [4,5,6,7]
//        [8,9]
//
//        Output: [1,4,8,2,5,9,3,6,7].
public class ZigzagIterator281 {
    int n=0;
    int curLevel=0;
    List<Deque<Integer>> storage=new ArrayList<>();
    public ZigzagIterator281(List<Integer> v1, List<Integer> v2) {

        if (!v1.isEmpty()) {
            this.storage.add(new LinkedList<>(v1));
            this.n++;
        }
        if (!v2.isEmpty()) {
            this.storage.add(new LinkedList<>(v2));
            this.n++;
        }
    }

    public int next() {
        // System.out.println("curLevel:"+this.curLevel);
        // System.out.println("storage:"+this.storage);
        int ans=this.storage.get(this.curLevel).removeFirst();
//         System.out.println(ans);
        if(this.storage.get(this.curLevel).isEmpty()){
            this.n--;
            this.storage.remove(this.curLevel);
            if(this.curLevel==this.n){
                this.curLevel--;
            }
        }else{
            this.curLevel=(this.curLevel+1)%this.n;
        }
        return ans;
    }

    public boolean hasNext() {
        return this.n!=0;
    }

}
