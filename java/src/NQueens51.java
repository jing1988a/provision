//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//        Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//        Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//        Example:
//
//        Input: 4
//        Output: [
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
//        Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
//        Seen this question in a real interview before?





















import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList();
        dfs(n , 0 , new ArrayList<Integer>() ,  ans);
        return ans;
    }
    private void dfs(int n , int level , ArrayList<Integer> candidate , List<List<String>> ans ){
        if(level==n){
            ans.add(formated(candidate , n));
            return ;
        }
        for(int i=0 ; i<n ;i++){
            if(isValid(candidate , level , i)){
                candidate.add(i);
                dfs(n , level+1 , candidate , ans);
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
    private List<String> formated(List<Integer> candidate , int n){
        List<String> ans=new ArrayList<>();
        for(Integer i:candidate){
            StringBuilder temp=new StringBuilder();
            for(int j=0 ; j<n ; j++){
                temp.append('.');

            }
            temp.setCharAt(i , 'Q');
            ans.add(temp.toString());
        }
        return ans;
    }

    static public void main(String[] args){
        NQueens51 test=new NQueens51();
        System.out.println(test.solveNQueens(4));
    }
}
