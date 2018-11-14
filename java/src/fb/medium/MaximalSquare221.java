package fb.medium;

//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//        Example:
//
//        Input:
//
//        1 0 1 0 0
//        1 0 1 1 1
//        1 1 1 1 1
//        1 0 0 1 0
//
//        Output: 4






public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        if(n==0){return 0;}
        int m=matrix[0].length;
        if(m==0){return 0 ;}
        int[][] dp= new int[n][m];
        int ans=0;
        for(int i=0 ; i<n ;i++){
            for(int j=0 ; j <m ; j++ ){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1;
                    ans=1;
                }
            }
        }

        for(int i=1 ; i<n ;i++){
            for(int j=1 ; j <m ; j++ ){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j] ,  Math.min(dp[i][j-1] , dp[i-1][j-1]));
                    ans=Math.max(ans , dp[i][j]);
                }
            }
        }
        return ans*ans;


    }
}
