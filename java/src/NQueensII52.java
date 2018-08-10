//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//        Given an integer n, return the number of distinct solutions to the n-queens puzzle.
//
//        Example:
//
//        Input: 4
//        Output: 2
//        Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
//        [
//        [".Q..",  // Solution 1
//        "...Q",
//        "Q...",
//        "..Q."],
//
//        ["..Q.",  // Solution 2
//        "Q...",
//        "...Q",
//        ".Q.."]
//        ]


import java.util.ArrayList;
import java.util.List;

public class NQueensII52 {
    int ans=0;
    public int totalNQueens(int n) {

        dfs(n , 0 , new ArrayList<Integer>() );
        return ans;
    }


    private void dfs(int n , int level , ArrayList<Integer> candidate  ){
        if(level==n){
            this.ans++;
            return ;
        }
        for(int i=0 ; i<n ;i++){
            if(isValid(candidate , level , i)){
                candidate.add(i);
                dfs(n , level+1 , candidate);
                candidate.remove(candidate.size()-1);
            }
        }
    }
    private boolean isValid(List<Integer> candidate , int level , int i){
        for(Integer c:candidate){
            if(c==i){
                return false;
            }
        }
        int r=i;
        int l=i;
        while(level>0){
            r++;
            l--;
            level--;
            if(candidate.get(level)==r ||candidate.get(level)==l){
                return false;
            }
        }
        return true;
    }
//     private List<String> formated(List<Integer> candidate , int n){
//         List<String> ans=new ArrayList<>();
//         for(Integer i:candidate){
//             StringBuilder temp=new StringBuilder();
//             for(int j=0 ; j<n ; j++){
//                 temp.append('.');

//             }
//             temp.setCharAt(i , 'Q');
//             ans.add(temp.toString());
//         }
//         return ans;
//     }
}
