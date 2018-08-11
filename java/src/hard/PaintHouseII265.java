package hard;
//There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
//
//        The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
//
//        Note:
//        All costs are positive integers.
//
//        Example:
//
//        Input: [[1,5,3],[2,9,4]]
//        Output: 5
//        Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
//        Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
//        Follow up:
//        Could you solve it in O(nk) runtime?

public class PaintHouseII265 {
//    dp[i][j] is the min cost if paint all the way to house i with color j on house i
//    dp[i][j]=min(dp[i-1][0] ....dp[i-1][n]) exclude dp[i-1][j]
    public int minCostII(int[][] costs) {
        int n =costs.length;
        if(n==0){return 0;}
        int m=costs[0].length;
        if(m==0){return 0;}
        int[][] dp=new int[n][m];
        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }


        for(int j=0 ; j<m ; j++){
            dp[0][j]=costs[0][j];
        }
        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                for(int k=0 ; k<m ; k++){
                    if(k==j){continue;}
                    dp[i][j]=Math.min(dp[i-1][k]+costs[i][j] , dp[i][j]);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0 ; i<m ; i++){
            ans=Math.min(ans , dp[n-1][i]);
        }
        return ans;
    }
}
