package medium;
//Design a Tic-tac-toe game that is played between two players on a n x n grid.
//
//        You may assume the following rules:
//
//        A move is guaranteed to be valid and is placed on an empty block.
//        Once a winning condition is reached, no more moves is allowed.
//        A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
//        Example:
//        Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
//
//        TicTacToe toe = new TicTacToe(3);
//
//        toe.move(0, 0, 1); -> Returns 0 (no one wins)
//        |X| | |
//        | | | |    // Player 1 makes a move at (0, 0).
//        | | | |
//
//        toe.move(0, 2, 2); -> Returns 0 (no one wins)
//        |X| |O|
//        | | | |    // Player 2 makes a move at (0, 2).
//        | | | |
//
//        toe.move(2, 2, 1); -> Returns 0 (no one wins)
//        |X| |O|
//        | | | |    // Player 1 makes a move at (2, 2).
//        | | |X|
//
//        toe.move(1, 1, 2); -> Returns 0 (no one wins)
//        |X| |O|
//        | |O| |    // Player 2 makes a move at (1, 1).
//        | | |X|
//
//        toe.move(2, 0, 1); -> Returns 0 (no one wins)
//        |X| |O|
//        | |O| |    // Player 1 makes a move at (2, 0).
//        |X| |X|
//
//        toe.move(1, 0, 2); -> Returns 0 (no one wins)
//        |X| |O|
//        |O|O| |    // Player 2 makes a move at (1, 0).
//        |X| |X|
//
//        toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
//        |X| |O|
//        |O|O| |    // Player 1 makes a move at (2, 1).
//        |X|X|X|
//        Follow up:
//        Could you do better than O(n2) per move() operation?
public class DesignTicTacToe348 {
    int[][] board;
    int n=0;




    int[] rowCheck;
    int[] colCheck;
    int diagCheck;
    int reverseDiagCheck;
    public DesignTicTacToe348(int n) {
        board=new int[n][n];
        this.n=n;


        rowCheck=new int[n];
        colCheck=new int[n];
        diagCheck=0;
        reverseDiagCheck=0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        this.board[row][col]=player;
//        return check(row , col ,  player);


        return check2(row , col ,  player);
    }

    private int check2(int row , int col , int player){
        if(player==1) {
            this.rowCheck[row]++;
            this.colCheck[col]++;
            if(row==col){
                this.diagCheck++;
            }
            if(row+col==(this.n-1)){
                this.reverseDiagCheck++;
            }

        }else{
            this.rowCheck[row]--;
            this.colCheck[col]--;
            if(row==col){
                this.diagCheck--;
            }
            if(row+col==(this.n-1)){
                this.reverseDiagCheck--;
            }
        }


        if(player==1){
            if(this.rowCheck[row]==this.n){return player;}
            if(this.colCheck[col]==this.n){return player;}
            if(this.diagCheck==this.n){return player;}
            if(this.reverseDiagCheck==this.n){return player;}
        }else{
            if(this.rowCheck[row]==-this.n){return player;}
            if(this.colCheck[col]==-this.n){return player;}
            if(this.diagCheck==-this.n){return player;}
            if(this.reverseDiagCheck==-this.n){return player;}
        }
        return 0;
    }


    private int check(int row , int col , int player){
        int i=0;
        while(i<this.n){
            if(this.board[i][col]!=player){
                break;
            }
            i++;
        }
        if(i==this.n){return player;}

        i=0;
        while(i<this.n){
            if(this.board[row][i]!=player){
                break;
            }
            i++;
        }
        if(i==this.n){return  player;}

        if(col==row){
            i=0;
            while(i<this.n){
                if(this.board[i][i]!=player){
                    break;
                }
                i++;
            }
            if(i==this.n){return  player;}
        }
        if(col+row==(this.n-1)){
            i=0;
            while(i<this.n){
                if(this.board[i][this.n-1-i]!=player){
                    break;
                }
                i++;
            }
            if(i==this.n){return  player;}
        }


        return 0;
    }
}
