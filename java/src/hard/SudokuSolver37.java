package hard;//LeetCode
//        Explore
//        Problems
//        Mock
//        Contest
//        Articles
//        Discuss
//        Store
//        New Playground
//        3
//        jing1988a
//
//        37. Sudoku Solver
//        DescriptionHintsSubmissionsDiscussSolution
//        Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//        A sudoku solution must satisfy all of the following rules:
//
//        Each of the digits 1-9 must occur exactly once in each row.
//        Each of the digits 1-9 must occur exactly once in each column.
//        Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//        Empty cells are indicated by the character '.'.
//
//
//        A sudoku puzzle...
//
//
//        ...and its solution numbers marked in red.
//
//        Note:
//
//        The given board contain only digits 1-9 and the character '.'.
//        You may assume that the given Sudoku puzzle will have a single unique solution.
//        The given board size is always 9x9.
//


import javafx.util.Pair;

import java.util.Stack;

public class SudokuSolver37 {


    //     question: only one ans or all the answers??
//     can i assume always have an answer?
//     can i assume input always valid?

    //     brute force: write a check function for every state and loop every possibility.
//     dfs
    boolean found=false;
    public void solveSudoku(char[][] board) {
        int n=board.length;
        if(n!=9){return;}
        int m=board[0].length;
        if(m!=9){return;}

        boolean[][] rowCheck=new boolean[9][9];
        boolean[][] colCheck=new boolean[9][9];
        boolean[][] blockCheck=new boolean[9][9];
        Stack<Pair<Integer , Integer>> s=new Stack();
        for(int i=0 ; i<9;i++){
            for(int j=0 ; j<9 ; j++){
                if(Character.isDigit(board[i][j])){
                    int temp=Character.getNumericValue(board[i][j]);
                    rowCheck[i][temp-1]=true;
                    colCheck[j][temp-1]=true;
                    blockCheck[(i/3)*3+j/3][temp-1]=true;
                }else{
                    Pair<Integer , Integer> temp=new Pair(i , j);
                    s.push(temp);
                }
            }
        }
        dfs(s , board , rowCheck , colCheck , blockCheck) ;
    }

    private void dfs(Stack<Pair<Integer , Integer>> s , char[][] board , boolean[][] rowCheck , boolean[][] colCheck  , boolean[][] blockCheck     ){
        //System.out.println(q);
        if(s.isEmpty()){
            this.found=true;
        }
        if(this.found){return ;}
        Pair<Integer , Integer> p=s.pop();
        int i=p.getKey();
        int j=p.getValue();
        for(int v=0 ; v<9  ; v++){
            if(!isValid(i , j , v , rowCheck , colCheck , blockCheck)){
                continue;
            }

            board[i][j]=(char)(v+1+'0');
            rowCheck[i][v]=true;
            colCheck[j][v]=true;
            blockCheck[(i/3)*3+j/3 ][v]=true;
            dfs(s , board , rowCheck , colCheck , blockCheck);
            if(this.found){return ;}
            board[i][j]='.';
            rowCheck[i][v]=false;
            colCheck[j][v]=false;
            blockCheck[(i/3)*3+j/3 ][v]=false;
        }
        s.push(p);
    }
    private boolean isValid( int i , int j  , int  v , boolean[][] rowCheck , boolean[][] colCheck  , boolean[][] blockCheck){
        if(rowCheck[i][v]){return false;}
        if(colCheck[j][v]){return false;}
        if(blockCheck[(i/3)*3 +j/3][v]){return false;}
        return true;
    }



    static public void main(String[] args){
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver37 test = new SudokuSolver37();
        test.solveSudoku(board);
        System.out.println(board);
    }
}
