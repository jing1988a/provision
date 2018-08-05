package medium;

import java.util.Arrays;

//Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//
//        Example:
//
//        Input: nums = [-2,0,1,3], and target = 2
//        Output: 2
//        Explanation: Because there are two triplets which sums are less than 2:
//        [-2,0,1]
//        [-2,0,3]
public class ThreeSumSmaller259 {
    public int threeSumSmaller(int[] nums, int target) {
        int l=nums.length;
        if(l<3){return 0;}
        Arrays.sort(nums);
        int ans=0;
        for(int i=0 ; i<l-2 ; i++){
            int j=i+1;
            int k=l-1;
            while(j<k){
                int curSum=nums[i]+nums[j]+nums[k];
                if(curSum<target){
                    ans+=k-j;
                    j++;
                }else{
                    k--;
                }

            }
        }
        return ans;
    }
}
