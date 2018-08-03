package medium;//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//        Example:
//
//        Input: s = 7, nums = [2,3,1,2,4,3]
//        Output: 2
//        Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//        Follow up:
//        If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).


// will there be 0??



public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen(int s, int[] nums) {
        if(s==0){return 0;}
        int l=nums.length;
        int cur=0;
        int start=0;
        int end=0;
        int ans=Integer.MAX_VALUE;
        while(end<l){
            cur+=nums[end];
            while(cur>=s){
                if(cur-nums[start]>=s){
                    cur-=nums[start];
                    start++;
                }else{
                    break;
                }
            }
            if(cur>=s){
                ans=Math.min(ans , end-start+1);
            }
            end++;
        }
        if(ans==Integer.MAX_VALUE){return 0;}
        return ans;

    }


    static public void main(String[] args){
        MinimumSizeSubarraySum209 test=new MinimumSizeSubarraySum209();
        int[] nums=new int[] {2,3,1,2,4,3};
        int s=7;
        test.minSubArrayLen(s , nums);
    }
}
