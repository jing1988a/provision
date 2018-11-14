package eight_hundred_plus;

import java.util.ArrayList;
import java.util.List;

//We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.
//
//        Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".
//
//        The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)
//
//        Example 1:
//        Input: "(123)"
//        Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
//        Example 2:
//        Input: "(00011)"
//        Output:  ["(0.001, 1)", "(0, 0.011)"]
//        Explanation:
//        0.0, 00, 0001 or 00.01 are not allowed.
//        Example 3:
//        Input: "(0123)"
//        Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
//        Example 4:
//        Input: "(100)"
//        Output: [(10, 0)]
//        Explanation:
//        1.0 is not allowed.
//
//
//        Note:
//
//        4 <= S.length <= 12.
//        S[0] = "(", S[S.length - 1] = ")", and the other elements in S are digits.
public class AmbiguousCoordinates816 {
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans=new ArrayList<>();
        S=S.substring(1, S.length()-1);
        for(int i=1; i<S.length() ; i++){
            List<String> lCandidate=getCandidate(S.substring(0 , i));
            List<String> rCandidate=getCandidate(S.substring(i));
            if(rCandidate.size()==0||lCandidate.size()==0){
                continue;
            }
            for(String l:lCandidate){
                for(String r:rCandidate){
                    ans.add("("+ l+", "+r+")");
                }
            }
        }
        return ans;
    }

    private List<String> getCandidate(String str){
        List<String> ans=new ArrayList<>();

        int l=str.length();
        if(l==0){return ans;}
        if(l==1){
            ans.add(str);
            return ans;
        }
        if(str.startsWith("0")){
            if(!str.endsWith("0")){
                ans.add("0."+str.substring(1));
            }
            return ans;
        }
        ans.add(str);
        if(str.endsWith("0")){
            return ans;
        }
        for(int i=1 ; i<l ; i++){
            ans.add(str.substring(0 , i)+"."+str.substring(i ));
        }
        return ans;
    }
}
