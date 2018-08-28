package fb.medium;//Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
//
//        Note:
//        The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
//
//        Example 1:
//
//        Input: nums = [1, -1, 5, -2, 3], k = 3
//        Output: 4
//        Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
//        Example 2:
//
//        Input: nums = [-2, -1, 2, 1], k = 1
//        Output: 2
//        Explanation: The subarray [-1, 2] sums to 1 and is the longest.

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans=0;
        int curSum=0;
        HashMap<Integer , Integer> SumIdxMap=new HashMap<>();
        SumIdxMap.put(0 ,  -1);
        for(int i=0 ; i<nums.length; i++){
            curSum+=nums[i];
            if(SumIdxMap.containsKey(curSum-k)){
                ans=Math.max(ans , i-SumIdxMap.get(curSum-k));
            }
            if(!SumIdxMap.containsKey(curSum)){SumIdxMap.put(curSum , i);}
        }
        return ans;
    }
}
