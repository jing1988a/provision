package eight_hundred_plus;

import java.util.HashMap;
import java.util.Map;

//A sequence X_1, X_2, ..., X_n is fibonacci-like if:
//
//        n >= 3
//        X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
//        Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
//
//        (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
//
//
//
//        Example 1:
//
//        Input: [1,2,3,4,5,6,7,8]
//        Output: 5
//        Explanation:
//        The longest subsequence that is fibonacci-like: [1,2,3,5,8].
//        Example 2:
//
//        Input: [1,3,7,11,12,14,18]
//        Output: 3
//        Explanation:
//        The longest subsequence that is fibonacci-like:
//        [1,11,12], [3,11,14] or [7,11,18].
//
//
//        Note:
//
//        3 <= A.length <= 1000
//        1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
//        (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
public class LengthofLongestFibonacciSubsequence873 {
    public int lenLongestFibSubseq(int[] A) {
        int ans=0;
        int l=A.length;
        int[][] dp=new int[l][l];
        for(int i=0 ; i<l ; i++){
            for(int j=0 ; j<l ;j++){
                dp[i][j]=2;
            }
        }
        Map<Integer , Integer> valIdx=new HashMap<>();
        for(int i=0  ; i<l ; i++){
            valIdx.put(A[i] , i);
        }
        for(int k=2 ; k<l ; k++){
            for(int j=1 ; j<k ; j++){
                int candidate=A[k]-A[j];
                if(candidate>A[j]){continue;}
                if(valIdx.containsKey(candidate)){
                    int i=valIdx.get(candidate);
                    dp[j][k]=dp[i][j]+1;
                    ans=Math.max(ans , dp[j][k]);
                }
            }
        }
        return ans;

    }
}
