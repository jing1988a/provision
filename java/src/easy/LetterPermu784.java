package easy;//Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
//
//        Examples:
//        Input: S = "a1b2"
//        Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//        Input: S = "3z4"
//        Output: ["3z4", "3Z4"]
//
//        Input: S = "12345"
//        Output: ["12345"]
//        Note:
//
//        S will be a string with length at most 12.
//        S will consist only of letters or digits.
//


import java.util.ArrayList;
import java.util.List;

public class LetterPermu784 {
    private void recurBuild(String S , int idx , int l , StringBuilder candidate , List<String> ans){
        if(idx==l){
            ans.add(candidate.toString());
            return;
        }
        char c=S.charAt(idx);
        if(Character.isDigit(c)){
            candidate.append(c);
            recurBuild(S , idx+1 , l , candidate , ans);
        }else{
            candidate.append(Character.toLowerCase(c));
            recurBuild(S , idx+1 , l , candidate , ans);
            candidate.deleteCharAt(candidate.length()-1);
            candidate.append(Character.toUpperCase(c));
            recurBuild(S , idx+1 , l , candidate , ans);
        }
        candidate.deleteCharAt(candidate.length()-1);
    }
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        int l=S.length();
        if(l==0){
            return ans;
        }
        recurBuild(S , 0 , l , new StringBuilder() , ans);
        return ans;
    }
}
