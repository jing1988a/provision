package medium;//You are given a m x n 2D grid initialized with these three possible values.
//
//        -1 - A wall or an obstacle.
//        0 - A gate.
//        INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//        Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//
//        Example:
//
//        Given the 2D grid:
//
//        INF  -1  0  INF
//        INF INF INF  -1
//        INF  -1 INF  -1
//        0  -1 INF INF
//        After running your function, the 2D grid should be:
//
//        3  -1   0   1
//        2   2   1  -1
//        1  -1   2  -1
//        0  -1   3   4
//


import java.util.ArrayList;
import java.util.List;
public class GateAndWall286 {
    public void wallsAndGates(int[][] rooms) {
        int n=rooms.length;
        if(n==0){
            return ;
        }
        int m=rooms[0].length;
        for(int i=0 ; i<n;i++){
            for (int j=0;j<m ; j++){
                if(rooms[i][j]==0){
                    bfs(rooms , i , j  , n , m );
                }
            }
        }
    }
    private void bfs(int[][] rooms , int i , int j  , int n , int m ){
        int[][] directions={ {0 , 1}  , {0 , -1} , {1 , 0} , {-1 , 0}};
        boolean[][] visited=new boolean[n][m];
        List<Integer[]> q=new ArrayList<>();
        q.add(new Integer[] {i , j});
        int cur=0;
        while(!q.isEmpty()){
            List<Integer[]> p =new ArrayList<>();
            for(Integer[] curLoc: q){
                for(int[] d:directions){
                    int x=curLoc[0]+d[0];
                    int y=curLoc[1]+d[1];
                    if(0<=x && x<n && 0<=y && y<m && !visited[x][y]){
                        visited[x][y]=true;
                        if(rooms[x][y]>cur+1){
                            rooms[x][y]=cur+1;
                            p.add(new Integer[] {x , y});
                        }
                    }
                }
            }
            cur++;
            q=p;
        }
    }
}
