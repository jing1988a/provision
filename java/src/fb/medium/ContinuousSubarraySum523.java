package fb.medium;//Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
//
//        Example 1:
//        Input: [23, 2, 4, 6, 7],  k=6
//        Output: True
//        Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
//        Example 2:
//        Input: [23, 2, 6, 4, 7],  k=6
//        Output: True
//        Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
//        Note:
//        The length of the array won't exceed 10,000.
//        You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
//


import java.util.HashMap;

public class ContinuousSubarraySum523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        //brute force: find all sum for all combination O(n^2) and check if it%6==0;
        // can we do O(n)??
        //what we do if we only need sum to certain num???   HashMap
        int l = nums.length;
        HashMap<Integer, Integer> modeToIdx = new HashMap<>();
        modeToIdx.put(0, -1);
        int curSum = 0;
        for (int i = 0; i < l; i++) {
            curSum += nums[i];
            if (k == 0) {
                if (modeToIdx.containsKey(curSum) && i - modeToIdx.get(curSum) > 1) {
                    return true;
                }else{
                    modeToIdx.put(curSum , i);
                }
            } else {
                int curMode = curSum % k;
                if (modeToIdx.containsKey(curMode)) {
                    if (i - modeToIdx.get(curMode) > 1) {
                        return true;
                    }
                }else {
                    modeToIdx.put(curMode , i);
                }

            }
        }
        return false;
    }
}
