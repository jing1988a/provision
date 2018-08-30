package fb.medium;

//Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
//        The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
//        Note: You can only put the bomb at an empty cell.
//
//        Example:
//
//        Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
//        Output: 3
//        Explanation: For the given grid,
//
//        0 E 0 0
//        E 0 W E
//        0 E 0 0
//
//        Placing a bomb at (1,1) kills 3 enemies.

public class BombEnemy361 {
    public int maxKilledEnemies(char[][] grid) {
        int n=grid.length;
        if(n==0){return 0;}
        int m=grid[0].length;
        if(m==0){return 0;}
        int[][] upE=findUpE(grid , n , m);
        int[][] downE=findDownE(grid , n , m);
        int[][] leftE=findLeftE(grid , n , m);
        int[][] rightE=findRightE(grid , n , m);
        int ans=0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]=='0') {
                    ans = Math.max(ans, upE[i][j] + downE[i][j] + leftE[i][j] + rightE[i][j]);
                }
            }
        }
        return ans;
    }
    private int[][] findUpE(char[][] grid, int n , int m ){
        int[][] ans=new int[n][m];
        for(int i=0 ; i<m ; i++){
            if(grid[0][i]=='E') {
                ans[0][i]++;
            }
        }
        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                ans[i][j]+=ans[i-1][j];
                if(grid[i-1][j]=='W'){
                    ans[i][j]=0;
                }
                if(grid[i][j]=='E') {
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }
    private int[][] findDownE(char[][] grid, int n , int m ){
        int[][] ans=new int[n][m];
        for(int i=0 ; i<m ; i++){
            if(grid[n-1][i]=='E') {
                ans[n-1][i]++;
            }
        }
        for(int i=n-2 ; i>-1 ; i--){
            for(int j=0 ; j<m ; j++){
                ans[i][j]+=ans[i+1][j];
                if(grid[i+1][j]=='W'){
                    ans[i][j]=0;
                }
                if(grid[i][j]=='E') {
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }
    private int[][] findLeftE(char[][] grid, int n , int m ){
        int[][] ans=new int[n][m];
        for(int i=0 ; i<n ; i++){
            if(grid[i][0]=='E') {
                ans[i][0]++;
            }
        }
        for(int j=1 ; j<m ; j++){
            for(int i=0 ; i<n ; i++){
                ans[i][j]+=ans[i][j-1];
                if(grid[i][j-1]=='W'){
                    ans[i][j]=0;
                }
                if(grid[i][j]=='E') {
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }
    private int[][] findRightE(char[][] grid, int n , int m ){
        int[][] ans=new int[n][m];
        for(int i=0 ; i<n ; i++){
            if(grid[i][m-1]=='E') {
                ans[i][m-1]++;
            }
        }
        for(int j=m-2 ; j>-1 ; j--){
            for(int i=0 ; i<n ; i++){
                ans[i][j]+=ans[i][j+1];
                if(grid[i][j+1]=='W'){
                    ans[i][j]=0;
                }
                if(grid[i][j]=='E') {
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }
    static public void main(String[] ha){
//        char[][] grid={{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        char[][] grid={{'0' , 'E'}};
        BombEnemy361 test=new BombEnemy361();
        test.maxKilledEnemies(grid);
    }
}
