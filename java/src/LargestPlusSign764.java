//In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If there is none, return 0.
//
//        An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.
//
//        Examples of Axis-Aligned Plus Signs of Order k:
//
//        Order 1:
//        000
//        010
//        000
//
//        Order 2:
//        00000
//        00100
//        01110
//        00100
//        00000
//
//        Order 3:
//        0000000
//        0001000
//        0001000
//        0111110
//        0001000
//        0001000
//        0000000
//        Example 1:
//
//        Input: N = 5, mines = [[4, 2]]
//        Output: 2
//        Explanation:
//        11111
//        11111
//        11111
//        11111
//        11011
//        In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
//        Example 2:
//
//        Input: N = 2, mines = []
//        Output: 1
//        Explanation:
//        There is no plus sign of order 2, but there is of order 1.
//        Example 3:
//
//        Input: N = 1, mines = [[0, 0]]
//        Output: 0
//        Explanation:
//        There is no plus sign, so return 0.
//        Note:
//
//        N will be an integer in the range [1, 500].
//        mines will have length at most 5000.
//        mines[i] will be length 2 and consist of integers in the range [0, N-1].
//        (Additionally, programs submitted in C, C++, or C# will be judged with a slightly smaller time limit.)




// brute force is easy to think but slow.
//  there are lots of duplicate caculation, can we improve.
public class LargestPlusSign764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid=constructGrid(N , mines);
        int[][] dpUp=constructdpUp(grid , N);
        int[][] dpDown=constructdpDown(grid , N);
        int[][] dpLeft=constructdpLeft(grid , N);
        int[][] dpRight=constructdpRight(grid , N);
        int ans=0;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                int temp=Integer.MAX_VALUE;
                temp=Math.min(temp , dpUp[i][j]);
                temp=Math.min(temp , dpDown[i][j]);
                temp=Math.min(temp , dpLeft[i][j]);
                temp=Math.min(temp , dpRight[i][j]);
                ans=Math.max(ans , temp);
            }
        }
        return ans;

    }
    private int[][] constructGrid(int N , int[][] mines){
        int[][] grid=new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                grid[i][j]=1;
            }
        }
        for(int[] cell:mines){
            grid[cell[0]][cell[1]]=0;
        }
        return grid;
    }
    private int[][] constructdpUp(int[][] grid , int N){

        int[][] dp=new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                dp[i][j]=grid[i][j];
            }
        }



        for(int i=1 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(grid[i][j]==1){
                    dp[i][j]+=dp[i-1][j];
                }
            }
        }
        return dp;
    }
    private int[][] constructdpDown(int[][] grid , int N){

        int[][] dp=new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                dp[i][j]=grid[i][j];
            }
        }



        for(int i=N-2 ; i>-1 ; i--){
            for(int j=0 ; j<N ; j++){
                if(grid[i][j]==1){
                    dp[i][j]+=dp[i+1][j];
                }
            }
        }
        return dp;
    }
    private int[][] constructdpLeft(int[][] grid , int N){

        int[][] dp=new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                dp[i][j]=grid[i][j];
            }
        }



        for(int i=0 ; i<N ; i++){
            for(int j=1 ; j<N ; j++){
                if(grid[i][j]==1){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp;
    }
    private int[][] constructdpRight(int[][] grid , int N){

        int[][] dp=new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                dp[i][j]=grid[i][j];
            }
        }



        for(int i=0 ; i<N ; i++){
            for(int j=N-2 ; j>-1 ; j--){
                if(grid[i][j]==1){
                    dp[i][j]+=dp[i][j+1];
                }
            }
        }
        return dp;
    }

    static public void main(String[] args){
        int N=5;
        int[][] mines=new int[][] {{4,2}};
        LargestPlusSign764 test=new LargestPlusSign764();
        test.orderOfLargestPlusSign(N , mines);
    }
}
