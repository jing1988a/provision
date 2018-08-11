package hard;//Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
//
//        Note:
//        If n is the length of array, assume the following constraints are satisfied:
//
//        1 ≤ n ≤ 1000
//        1 ≤ m ≤ min(50, n)
//        Examples:
//
//        Input:
//        nums = [7,2,5,10,8]
//        m = 2
//
//        Output:
//        18
//
//        Explanation:
//        There are four ways to split nums into two subarrays.
//        The best way is to split it into [7,2,5] and [10,8],
//        where the largest sum among the two subarrays is only 18.


public class SplitArrayLargestSum410 {
//    int ans=Integer.MAX_VALUE;
//    int l=0;
//    public int splitArray(int[] nums, int m) {
//        this.l=nums.length;
//        dfs(nums , m  ,  0 ,   0);
//        return this.ans;
//    }
//
//    private void dfs(int[] nums , int m , int idx , int curMax){
//        if(idx==this.l && m==0){
//            this.ans=Math.min(this.ans , curMax);
//
//        }
//        if(idx==this.l || m==0){return ;}
//        int temp=0;
//        for(int i=idx ; i<this.l  ; i++){
//            temp+=nums[i];
//            dfs(nums , m-1 , i+1 , Math.max(curMax , temp));
//        }
//    }


    //    above is good but it is O(n^m)  will TLE for sure.  what we do???
//    1.
//
//    dp[i][j]  means 0 to i with j sub
//    then dp[i][j]=min(dp[i][j]   ,  max( dp[k][j-1] , sum(nums[k+1:i+1]))
    public int splitArray(int[] nums, int m) {
        int l=nums.length;
        int[][] dp=new int[l][m+1];
        for(int i=0 ; i<l;i++){
            for(int j=0 ; j<m+1 ; j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        int curSum=0;
        for(int i=0 ; i<l ; i++){
            curSum+=nums[i];
            dp[i][1]=curSum;
        }
        for(int j=2; j<m+1 ; j++){
            for(int i=1; i<l;i++){
                int temp=0;
                for(int k=0 ; k<i;k++){
                    temp+=nums[i-k];
                    dp[i][j]=Math.min(dp[i][j] , Math.max(dp[i-k-1][j-1]  , temp )   );
                }
            }
        }
        return dp[l-1][m];
    }

    static public void main(String[] arts){
        int[] nums={1 , 4 , 4};
        int m=3;
        SplitArrayLargestSum410 test=new SplitArrayLargestSum410();
        int ans=test.splitArray(nums , m);
        System.out.println(ans);
    }
}
