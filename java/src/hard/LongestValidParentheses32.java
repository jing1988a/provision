package hard;//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//        Example 1:
//
//        Input: "(()"
//        Output: 2
//        Explanation: The longest valid parentheses substring is "()"
//        Example 2:
//
//        Input: ")(()())"
//        Output: 4
//        Explanation: The longest valid parentheses substring is "()()"


//brute force.  n=len(s)
//for l=n->2
//    for i= 0->n
//        check if substring of s is valid.
//            if valid , return l

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        //dp : let dp[i] be the longestValidparentheses end at idx i
        int l=s.length();
        int[] dp=new int[l+1];
        int ans=0;
        for(int i=1 ; i<l ; i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i+1]=2+dp[i-1];
                }else{
                    if(dp[i]>0 && i-dp[i]-1>=0 && s.charAt(i-dp[i]-1)=='('){
                        dp[i+1]=dp[i]+2+dp[i-dp[i]-1];
                    }
                }
            }
            ans=Math.max(ans , dp[i+1]);
        }
        return ans;
//        "(()"
    }

}
