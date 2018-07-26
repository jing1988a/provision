//Given a grid where each entry is only 0 or 1, find the number of corner rectangles.
//
//        A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
//
//
//
//        Example 1:
//
//        Input: grid =
//        [[1, 0, 0, 1, 0],
//        [0, 0, 1, 0, 1],
//        [0, 0, 0, 1, 0],
//        [1, 0, 1, 0, 1]]
//        Output: 1
//        Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
//
//
//        Example 2:
//
//        Input: grid =
//        [[1, 1, 1],
//        [1, 1, 1],
//        [1, 1, 1]]
//        Output: 9
//        Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
//
//
//        Example 3:
//
//        Input: grid =
//        [[1, 1, 1, 1]]
//        Output: 0
//        Explanation: Rectangles must have four distinct corners.
//
//
//        Note:
//
//        The number of rows and columns of grid will each be in the range [1, 200].
//        Each grid[i][j] will be either 0 or 1.
//        The number of 1s in the grid will be at most 6000.
//

public class CornerRectangles750 {
    int ans=0;
    public int countCornerRectangles(int[][] grid) {
        int n=grid.length;
        if(n==0){return 0;}
        int m=grid[0].length;
        if(m==0){return 0;}
        for(int i=0; i<n-1 ; i++){
            for(int j=0 ; j<m-1 ; j++){
                if(grid[i][j]==1){
                    checkRec(grid , i , j  , n , m);
                }
            }
        }
        return this.ans;
    }
    private void checkRec(int[][] grid , int i , int j , int n , int m){
//        a= i , j
        for(int j2=j+1 ; j2<m ; j2++){
            if(grid[i][j2]==1){
//                b=i , j2
                for(int i2=i+1 ; i2<n ; i2++){
                    if(grid[i2][j]==1 && grid[i2][j2]==1){
                        this.ans++;
                    }
                }
            }
        }
    }
}
