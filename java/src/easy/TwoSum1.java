package easy;//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].
//

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> preValue=new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            int n=nums[i];
            if(preValue.containsKey(target-n)){
                int[] ans={preValue.get(target-n) , i};
                return ans;
            }
            preValue.put(n , i);
        }
        return null;
    }
}
