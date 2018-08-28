package fb.medium;


//
//import java.math.BigDecimal;
//class Solution {
//    public double knightProbability(int N, int K, int r, int c) {
//        double total_moves=Math.pow(8 , K);
//        int [][][] dp=new int[K+1][N][N];
//        dp[0][r][c]=1;
//        int[][] directions={{-2 , -1} , {-2, 1} ,{-1 , 2}  , {1 , 2} , {2 , 1} , {2 , -1}  ,{1 ,-2} , {-1 , -2}};
//
//        for(int z=1;  z<K+1  ; z++){
//            for(int x=0 ; x<N ; x++){
//                for(int y=0 ; y<N ; y++){
//                    for(int[] d:directions){
//                        int next_x=x+d[0];
//                        int next_y=y+d[1];
//                        if(next_x>=0&&next_x<N&&next_y>=0&&next_y<N){
//                            dp[z][next_x][next_y]+=dp[z-1][x][y];
//                        }
//                    }
//                }
//            }
//        }
//        double ans=0;
//
//        for(int x=0 ; x<N ; x++){
//            for(int y=0 ; y<N ; y++){
//                ans+=dp[K][x][y];
//            }
//        }
//
//        System.out.println(ans);
//        return (double)ans/total_moves;
//
//    }
//}
//On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
//
//        A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
//
//
//        Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
//
//        The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
//
//        Example:
//        Input: 3, 2, 0, 0
//        Output: 0.0625
//        Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
//        From each of those positions, there are also two moves that will keep the knight on the board.
//        The total probability the knight stays on the board is 0.0625.
//        Note:
//        N will be between 1 and 25.
//        K will be between 0 and 100.
//        The knight always initially starts on the board.






// dfs K steps and caculate all the steps that are still on the board   lots of duplcate calculation

public class KnightProbabilityChessboard688 {

    public double knightProbability(int N, int K, int r, int c) {
        long totalStep=(long)Math.pow(8 , K);

        int[][] directions={{-2 , -1} , {-2 , 1} , {-1 , 2} , {1 , 2} , {2, 1} , {2 , -1} ,{1 , -2} , {-1 , -2}  };
        int[][][] dp=new int[K+1][N][N];
        dp[0][r][c]=1;
        for(int k=1 ; k<K+1;k++){
            for(int i=0 ;i<N ; i++){
                for(int j=0; j<N ; j++){
                    for(int[] d:directions){
                        int nextI=i+d[0];
                        int nextJ=j+d[1];
                        if(0<=nextI && nextI<N && 0<=nextJ && nextJ<N){
                            dp[k][nextI][nextJ]+=dp[k-1][i][j];
                        }
                    }
                }
            }
        }
        long ans=0;
        for(int i=0 ;i<N ; i++){
            for(int j=0; j<N ; j++){
                ans+=dp[K][i][j];
            }
        }
        return ans/totalStep;

    }
}
