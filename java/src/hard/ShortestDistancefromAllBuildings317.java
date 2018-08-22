package hard;//You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//
//        Each 0 marks an empty land which you can pass by freely.
//        Each 1 marks a building which you cannot pass through.
//        Each 2 marks an obstacle which you cannot pass through.
//        Example:
//
//        Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
//
//        1 - 0 - 2 - 0 - 1
//        |   |   |   |   |
//        0 - 0 - 0 - 0 - 0
//        |   |   |   |   |
//        0 - 0 - 1 - 0 - 0
//
//        Output: 7
//
//        Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
//        the point (1,2) is an ideal empty land to build a house, as the total
//        travel distance of 3+3+1=7 is minimal. So return 7.


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistancefromAllBuildings317 {
    public int shortestDistance(int[][] grid) {
        int n=grid.length;
        if(n==0){return 0;}
        int m=grid[0].length;
        if(m==0){return 0;}
//        if(!connected(grid , n , m)){return -1;}
        int[][] distances=new int[n][m];
        int[][] visitCount=new int[n][m]; //重点
        int totalBuilding=0;
        for(int i=0 ; i<n ;i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==1){
                    totalBuilding++;
                    bfs(i , j  , distances , visitCount ,grid,  n , m );
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0 ; i<n ;i++){
            for(int j=0 ; j<m ; j++){
                if(distances[i][j]!=0&&grid[i][j]==0&&visitCount[i][j]==totalBuilding){ //重点
                    ans=Math.min(ans , distances[i][j]);
                }
            }
        }
        if(ans==Integer.MAX_VALUE){return -1;}
        return ans;
    }

    private void bfs(int i , int j , int[][] distances , int[][] visitCount,   int[][] grid, int n , int m){
        int[][] directions={{1 , 0} , {0 , -1} , {0 , 1} , {-1 , 0}};
        boolean[][] visited=new boolean[n][m];
        List<Pair<Integer , Integer>> q=new ArrayList();
        int curDis=0;
        q.add(new Pair(i , j));
        visited[i][j]=true;
        while(!q.isEmpty()){
            List<Pair<Integer , Integer>> p=new ArrayList();
            for(Pair<Integer, Integer> pair:q){
                int x=pair.getKey();
                int y=pair.getValue();
                distances[x][y]+=curDis;
                visitCount[x][y]++;
                for(int[] d:directions){
                    int nextI=x+d[0];
                    int nextJ=y+d[1];
                    if(nextI>=0&&nextI<n&&nextJ>=0&&nextJ<m&&!visited[nextI][nextJ]&&grid[nextI][nextJ]==0){
                        visited[nextI][nextJ]=true;
                        p.add(new Pair(nextI , nextJ));
                    }
                }
            }
            curDis++;
            q=p;
        }

    }

//    private boolean connected(int[][] grid , int n , int m){
//        int[][] gridCopy=new int[n][m];
//        int x=0;
//        int y=0;
//        for(int i=0 ; i<n; i++){
//            for(int j=0 ; j<m ; j++){
//                gridCopy[i][j]=grid[i][j];
//                if(grid[i][j]==1){
//                    x=i;
//                    y=j;
//                }
//            }
//        }
//        boolean[][] visited=new boolean[n][m];
//        dfs(x , y , gridCopy , n , m , visited );
//        for(int i=0 ; i<n; i++){
//            for(int j=0 ; i<m ; j++){
//                if(gridCopy[i][j]==1){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//
//    private void dfs(int x , int y , int[][] grid ,int n ,int m , boolean[][] visited){
//        visited[x][y]=true;
//        grid[x][y]=9;
//        int[][] directions={{1 , 0} , {0 , -1} , {0 , 1} , {-1 , 0}};
//        for(int[] d:directions){
//            int i=x+d[0];
//            int j=y+d[1];
//            if(i>=0&&i<n&&j>=0&&j<m&&grid[i][j]!=2){
//                dfs(i , j , grid , n , m , visited);
//            }
//        }
//    }


    static public void main(String[] args){
        ShortestDistancefromAllBuildings317 test=new ShortestDistancefromAllBuildings317();
        int[][] grid={{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},{1,0,0,1,0,1},{1,0,1,0,0,1},{1,0,0,0,0,1},{0,1,1,1,1,0}};
        System.out.println(test.shortestDistance(grid));

    }
}
