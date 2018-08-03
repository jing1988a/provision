package medium;//
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//        Example 1:
//
//        Input:
//        11110
//        11010
//        11000
//        00000
//
//        Output: 1
//        Example 2:
//
//        Input:
//        11000
//        11000
//        00100
//        00011
//
//        Output: 3


public class NumberOfIslands200 {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        if(n==0){return 0 ;}
        int m=grid[0].length;
        if(m==0){return 0;}
        int[][] visited=new int[n][m];
        int ans=0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]=='1' &&  visited[i][j]==0){
                    ans++;
                    dfs(grid , i , j , n , m , visited);
                }
            }
        }
        return ans;

    }

    private void dfs(char[][] grid , int i , int j , int n , int m , int[][] visited){
        visited[i][j]=1;
        int[][] direction={{0 , 1} , {0 , -1} , {1 , 0} , {-1 , 0} };
        for(int[] d:direction){
            int nextI=i+d[0];
            int nextJ=j+d[1];
            if(0<=nextI && nextI<n && 0<=nextJ && nextJ<m && grid[nextI][nextJ]=='1' && visited[nextI][nextJ]==0){
                dfs(grid  , nextI , nextJ , n , m , visited);
            }
        }
    }

}
