package eight_hundred_plus;



//On a N * N grid, we place some 1 * 1 * 1 cubes.
//
//        Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
//
//        Return the total surface area of the resulting shapes.
//
//
//
//        Example 1:
//
//        Input: [[2]]
//        Output: 10
//        Example 2:
//
//        Input: [[1,2],[3,4]]
//        Output: 34
//        Example 3:
//
//        Input: [[1,0],[0,2]]
//        Output: 16
//        Example 4:
//
//        Input: [[1,1,1],[1,0,1],[1,1,1]]
//        Output: 32
//        Example 5:
//
//        Input: [[2,2,2],[2,1,2],[2,2,2]]
//        Output: 46
//
//
//        Note:
//
//        1 <= N <= 50
//        0 <= grid[i][j] <= 50

public class SurfaceAreaof3DShapes892 {
    public int surfaceArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m; j++){
                if(grid[i][j]!=0) {
                    ans += grid[i][j] * 6-(grid[i][j]-1)*2;
                    if(i>0){
                        ans-=Math.min(grid[i-1][j] , grid[i][j])*2;
                    }
                    if(j>0){
                        ans-=Math.min(grid[i][j-1] , grid[i][j])*2;
                    }
                }
            }
        }
        return ans;
    }
}
