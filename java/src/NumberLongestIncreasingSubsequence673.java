//Given an unsorted array of integers, find the number of longest increasing subsequence.
//
//        Example 1:
//        Input: [1,3,5,4,7]
//        Output: 2
//        Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
//        Example 2:
//        Input: [2,2,2,2,2]
//        Output: 5
//        Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
//        Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.


public class NumberLongestIncreasingSubsequence673 {
    public int findNumberOfLIS(int[] nums) {
        int l=nums.length;
        if(l<2){return l;}
        int[][] dp=new int[l][2];
        for(int i=0;i<l;i++){
            dp[i][0]=1;
            dp[i][1]=1;
        }
        for(int i=1   ; i<l ; i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j][0]==dp[i][0]-1){
                        dp[i][1]+=dp[j][1];
                    }else if(dp[j][0]>dp[i][0]-1){
                        dp[i][0]=dp[j][0]+1;
                        dp[i][1]=dp[j][1];
                    }
                }
            }
        }
        int maxLen=0;
        for(int[] d:dp){
            maxLen=Math.max(maxLen , d[0]);
        }
        int ans=0;
        for(int[] d:dp){
            if(d[0]==maxLen){
                ans+=d[1];
            }

        }
        return ans;

    }
}
