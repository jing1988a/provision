package eight_hundred_plus;

import java.util.LinkedList;
import java.util.TreeMap;

//Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
//
//        Return any permutation of A that maximizes its advantage with respect to B.
//
//
//
//        Example 1:
//
//        Input: A = [2,7,11,15], B = [1,10,4,11]
//        Output: [2,11,7,15]
//        Example 2:
//
//        Input: A = [12,24,8,32], B = [13,25,32,11]
//        Output: [24,32,8,12]
//
//
//        Note:
//
//        1 <= A.length = B.length <= 10000
//        0 <= A[i] <= 10^9
//        0 <= B[i] <= 10^9
public class AdvantageShuffle870 {
    public int[] advantageCount(int[] A, int[] B) {
        //seems like a greedy, always pick smallest that has advantage.
        TreeMap<Integer , LinkedList<Integer>> mapB=new TreeMap<>();
        for(int i=0 ; i<B.length; i++){
            if(mapB.containsKey(B[i])){
                mapB.get(B[i]).add(i);
            }else{
                LinkedList<Integer> temp=new LinkedList<>();
                temp.addLast(i);
                mapB.put(B[i] , temp);
            }
        }
        int l=A.length;
        int[] ans=new int[l];
        for(int i=0 ; i<l ; i++){
            Integer k=mapB.lowerKey(A[i]);
            if(k==null){
                k=mapB.lastKey();
            }
            LinkedList<Integer> idxs=mapB.get(k);
            int idx=idxs.removeLast();
            ans[idx]=A[i];
            if(idxs.isEmpty()){
                mapB.remove(k);
            }
        }
        return ans;
        // O(NlogN)
    }
}
