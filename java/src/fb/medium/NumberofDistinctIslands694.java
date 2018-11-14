package fb.medium;

//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//        Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
//
//        Example 1:
//        11000
//        11000
//        00011
//        00011
//        Given the above grid map, return 1.
//        Example 2:
//        11011
//        10000
//        00001
//        11011
//        Given the above grid map, return 3.
//
//        Notice that:
//        11
//        1
//        and
//        1
//        11
//        are considered different island shapes, because we do not consider reflection / rotation.
//        Note: The length of each dimension in the given grid does not exceed 50.

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands694 {
    public int numDistinctIslands(int[][] grid) {
        int n=grid.length;
        if(n==0){return 0;}
        int m=grid[0].length;
        if(m==0){return 0;}
        Set<String> ans=new HashSet<>();
        for(int i=0 ; i <n; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==1){
                    Set<String> island=new HashSet<>();
                    dfs(grid , i , j , n , m , i , j , island);
                    ans.add(island.toString());
                }
            }
        }
        return ans.size();
    }

    private void dfs(int[][] grid , int i , int j , int n , int m , int TOP , int LEFT , Set<String> island){
        grid[i][j]=0;
//        island.add( (i-TOP)*m+j-LEFT );  这个想法很好  但是下面那个case 就跑不过， 用这个方法 那2个island  算出来是一样的  都是  【0 ， 1 ， 2， ，3 ， 4 ， 6】
//   [[1,1,1,1],
//    [1,0,1,0],
//    [0,0,0,0],
//    [0,1,1,1],
//    [1,1,0,1]]
        island.add(String.valueOf(i-TOP)+'_'+String.valueOf(j-LEFT));


        int[][] direction={  {0 , 1} , {0 , -1} , {1 , 0} , {-1 , 0} };
        for(int[] d:direction){
            int nextI=i+d[0];
            int nextJ=j+d[1];
            if(nextI>-1 && nextJ>-1 && nextI<n && nextJ<m && grid[nextI][nextJ]==1){
                dfs(grid , nextI , nextJ , n , m , TOP , LEFT , island);
            }
        }

    }

    static public void main(String[] args){
        NumberofDistinctIslands694 test=new NumberofDistinctIslands694();
        int[][] grid={{1,1,1,1},{1,0,1,0},{0,0,0,0},{0,1,1,1},{1,1,0,1}};
        test.numDistinctIslands(grid);
    }

//   [[1,1,1,1],
//    [1,0,1,0],
//    [0,0,0,0],
//    [0,1,1,1],
//    [1,1,0,1]]
//    Output:
//            1
//    Expected:2

}
