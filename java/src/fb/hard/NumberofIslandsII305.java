package fb.hard;//A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//        Example:
//
//        Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
//        Output: [1,1,2,3]
//        Explanation:
//
//        Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
//
//        0 0 0
//        0 0 0
//        0 0 0
//        Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
//
//        1 0 0
//        0 0 0   Number of islands = 1
//        0 0 0
//        Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
//
//        1 1 0
//        0 0 0   Number of islands = 1
//        0 0 0
//        Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
//
//        1 1 0
//        0 0 1   Number of islands = 2
//        0 0 0
//        Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
//
//        1 1 0
//        0 0 1   Number of islands = 3
//        0 1 0
//        Follow up:
//
//        Can you do it in time complexity O(k log mn), where k is the length of the positions?


import java.util.*;

public class NumberofIslandsII305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Union u=new Union();
        int l=positions.length;
        List<Integer> ans=new ArrayList();
        int[][] directions={{0 , 1} , {0 , -1} , {1 , 0} , {-1 , 0}};
        int[][] grid=new int[m][n];
        for(int i=0 ; i<l ; i++){
            int x=positions[i][0];
            int y=positions[i][1];
            grid[x][y]=1;
            int idx=x*n+y;
            int p1=u.findP(idx);
            for(int[] d: directions){
                int nextX=x+d[0];
                int nextY=y+d[1];
                if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n&&grid[nextX][nextY]==1){
                    int idx2=nextX*n+nextY;
                    int p2=u.findP(idx2);
                    u.unionP(p2 , p1);
                }
            }
            ans.add(u.totalP());

        }
        return ans;
    }


    class Union{
        Map<Integer , Integer> dict=new HashMap();
        int totalP=0;
        public int findP(int v){
            if(!this.dict.containsKey(v)){
                this.dict.put(v , v);
                this.totalP++;
            }
            if(this.dict.get(v)==v){
                return v;
            }
            int p=findP(this.dict.get(v));
            this.dict.put(v ,  p);
            return p;
        }
        public void unionP(int p , int q){
            if(p==q){return;}
            this.dict.put(p , q);
            this.totalP--;
        }
        public int totalP(){
            // Set<Integer> s=new HashSet();
            // for(Integer v:this.dict.keySet()){
            //     s.add(findP(v));
            // }
            // return s.size();
            return this.totalP;
        }
    }



    static public  void  main(String[]  args){
        NumberofIslandsII305 test=new NumberofIslandsII305();
        int[][] a={{0,0},{0,1},{1,2},{2,1}};
        System.out.println(test.numIslands2(3 , 3 , a));
    }
}
