package eight_hundred_plus;
//We are given an array A of positive integers, and two positive integers L and R (L <= R).
//
//        Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.
//
//        Example :
//        Input:
//        A = [2, 1, 4, 3]
//        L = 2
//        R = 3
//        Output: 3
//        Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
//        Note:
//
//        L, R  and A[i] will be an integer in the range [0, 10^9].
//        The length of A will be in the range of [1, 50000].

//Say count(B) is the number of subarrays that have all elements less than or equal to B. From the above reasoning, the answer is count(R) - count(L-1).
//
//        How do we compute count(B)? We remember cur, the number of contiguous, previous elements less than or equal to B. When we see a new element less than or equal to B, the number of valid subarrays ending at this position is cur + 1. When we see a new element greater than B, the number of valid subarrays ending at this position is 0.
public class NumberofSubarrayswithBoundedMaximum795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A , R)-count(A , L-1);
    }
    private  int count(int[] A , int target){
        int ans=0;
        int cur=0;
        for(int a:A){
            if(a<=target){
                cur+=1;
                ans+=cur;
            }else{
                cur=0;
            }
        }
        return ans;
    }
}
