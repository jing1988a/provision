package hard;//Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
//        Note: The input string may contain letters other than the parentheses ( and ).
//
//        Example 1:
//
//        Input: "()())()"
//        Output: ["()()()", "(())()"]
//        Example 2:
//
//        Input: "(a)())()"
//        Output: ["(a)()()", "(a())()"]
//        Example 3:
//
//        Input: ")("
//        Output: [""]
//
//
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses301 {
    public List<String> removeInvalidParentheses(String s) {
        //brute force dfs with memorization
        Set<String> visitedString=new HashSet<>();
        List<String> q=new ArrayList<>();
        q.add(s);
        List<String> ans=new ArrayList<>();
        boolean found=false;
        while(!found && !q.isEmpty()){
            List<String> p=new ArrayList<>();
            for(String cur:q){
                if(isValid(cur)){
                    found=true;
                    ans.add(cur);
                }
                for(int i=0 ; i<cur.length() ; i++){
                    if(cur.charAt(i)==')' || cur.charAt(i)=='('){
                    String nextString=cur.substring(0,i)+cur.substring(i+1);
                    if(!visitedString.contains(nextString)){
                        visitedString.add(nextString);
                        p.add(nextString);
                    }
                    }
                }
            }
            q=p;
        }
        return ans;
    }
    private boolean isValid(String s){
        int count=0;
        for(char c :s.toCharArray()){
            if(c=='('){
                count++;
            }else if(c==')'){
                count--;
            }
            if(count<0){return false;}
        }
        return count==0;
    }
}
