package medium;//Given a 2D board and a word, find if the word exists in the grid.
//
//        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//        Example:
//
//        board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//
//        Given word = "ABCCED", return true.
//        Given word = "SEE", return true.
//        Given word = "ABCB", return false.


public class WordSearch79 {
    boolean found=false;
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        if(n==0){return false;}
        int m=board[0].length;
        if(m==0){return false;}
        int l=word.length();
        if(l==0){return true;}
        boolean[][] visited= new boolean[n][m];
        for(int x=0 ; x<n;x++){
            for(int y=0 ; y<m; y++){
                visited[x][y]=false;
            }
        }
        for(int i=0 ; i<n;i++){
            for(int j=0 ; j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    visited[i][j]=true;
                    dfs(board , i , j ,  n , m , visited , word , 0 , l );
                    if(this.found) {
                        return true;
                    }
                    visited[i][j]=false;
                }
            }
        }
        return false;

    }


    private void dfs(char[][] board , int i , int j , int n , int m , boolean[][] visited , String word , int idx , int l){
        idx++;
        if(idx==l){
            this.found=true;
            return;
        }
        int[][] direction={{0 , 1} , {0 , -1} , {1 , 0} , {-1 , 0}};
        for(int[] d:direction){
            int x=i+d[0];
            int y=j+d[1];
            if(0<=x && x<n && 0<=y && y<m && !visited[x][y] && board[x][y]==word.charAt(idx)  ){
                visited[x][y]=true;
                dfs(board , x , y , n , m , visited , word , idx , l);

                if(this.found){
                    return;
                }
                visited[x][y]=false;
            }
        }
    }
}
