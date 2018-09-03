package eight_hundred_plus;

import java.util.HashSet;
import java.util.Set;

//We have an array A of non-negative integers.
//
//        For every (contiguous) subarray B = [A[i], A[i+1], ..., A[j]] (with i <= j), we take the bitwise OR of all the elements in B, obtaining a result A[i] | A[i+1] | ... | A[j].
//
//        Return the number of possible results.  (Results that occur more than once are only counted once in the final answer.)
//
//
//
//        Example 1:
//
//        Input: [0]
//        Output: 1
//        Explanation:
//        There is only one possible result: 0.
//        Example 2:
//
//        Input: [1,1,2]
//        Output: 3
//        Explanation:
//        The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
//        These yield the results 1, 1, 2, 1, 3, 3.
//        There are 3 unique values, so the answer is 3.
//        Example 3:
//
//        Input: [1,2,4]
//        Output: 6
//        Explanation:
//        The possible results are 1, 2, 3, 4, 6, and 7.
//
//
//        Note:
//
//        1 <= A.length <= 50000
//        0 <= A[i] <= 10^9
public class BitwiseORsofSubarrays898 {
    public int subarrayBitwiseORs(int[] A) {
        int l=A.length;
        int[][] dp=new int[l][l];
        Set<Integer> ans=new HashSet<>();
        for(int i=0 ; i<l ; i++){
            for(int j=i ; j<l; j++){
                if(i==j){
                    dp[i][j]=A[i];
                    ans.add(dp[i][j]);
                }else{
                    dp[i][j]=A[j]|dp[i][j-1];
                    ans.add(dp[i][j]);
                }
            }
        }
        return ans.size();

    }
}
