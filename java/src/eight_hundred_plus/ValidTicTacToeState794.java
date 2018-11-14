package eight_hundred_plus;
//A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
//
//        The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.
//
//        Here are the rules of Tic-Tac-Toe:
//
//        Players take turns placing characters into empty squares (" ").
//        The first player always places "X" characters, while the second player always places "O" characters.
//        "X" and "O" characters are always placed into empty squares, never filled ones.
//        The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
//        The game also ends if all squares are non-empty.
//        No more moves can be played if the game is over.
//        Example 1:
//        Input: board = ["O  ", "   ", "   "]
//        Output: false
//        Explanation: The first player always plays "X".
//
//        Example 2:
//        Input: board = ["XOX", " X ", "   "]
//        Output: false
//        Explanation: Players take turns making moves.
//
//        Example 3:
//        Input: board = ["XXX", "   ", "OOO"]
//        Output: false
//
//        Example 4:
//        Input: board = ["XOX", "O O", "XOX"]
//        Output: true
//        Note:
//
//        board is a length-3 array of strings, where each string board[i] has length 3.
//        Each board[i][j] is a character in the set {" ", "X", "O"}.
public class ValidTicTacToeState794 {
    public boolean validTicTacToe(String[] board) {
        int cX=count(board , 'X');
        int cO=count(board , 'O');
        if(isWin(board , 'X')){
            return cX==cO+1;
        }
        if(isWin(board , 'O')){
            return cX==cO;
        }
        return cX==cO||cX==(cO+1);
    }
    private int count(String[] board , char c){
        int count=0;
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(board[i].charAt(j)==c){
                    count++;
                }
            }
        }
        return count;
    }
    private  boolean isWin(String[] board , char c){
        for(int i=0 ; i<3 ; i++){
            int count=0;
            for(int j=0 ; j<3 ; j++){
                if(board[i].charAt(j)==c){
                    count++;
                }
            }
            if(count==3){
                return true;
            }
        }
        for(int j=0 ; j<3 ; j++){
            int count=0;
            for(int i=0 ; i<3 ; i++){
                if(board[i].charAt(j)==c){
                    count++;
                }
            }
            if(count==3){
                return true;
            }
        }
        int count=0;
        for(int i=0 ; i<3 ; i++){
            if(board[i].charAt(i)==c){
                count++;
            }
        }
        if(count==3){
            return true;
        }
        count=0;
        for(int i=0 ; i<3 ; i++){
            if(board[i].charAt(2-i)==c){
                count++;
            }
        }
        if(count==3){
            return true;
        }
        return false;
    }
}

