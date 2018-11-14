package fb.hard;//
//
//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//        '.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial).
//
//        Note:
//
//        s could be empty and contains only lowercase letters a-z.
//        p could be empty and contains only lowercase letters a-z, and characters like . or *.
//        Example 1:
//
//        Input:
//        s = "aa"
//        p = "a"
//        Output: false
//        Explanation: "a" does not match the entire string "aa".
//        Example 2:
//
//        Input:
//        s = "aa"
//        p = "a*"
//        Output: true
//        Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//        Example 3:
//
//        Input:
//        s = "ab"
//        p = ".*"
//        Output: true
//        Explanation: ".*" means "zero or more (*) of any character (.)".
//        Example 4:
//
//        Input:
//        s = "aab"
//        p = "c*a*b"
//        Output: true
//        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
//        Example 5:
//
//        Input:
//        s = "mississippi"
//        p = "mis*is*p*."
//        Output: false




//dp[i][j] is true when s[i-1]   p[j-1]   is a match

public class RegularExpressionMatching10 {
        public boolean isMatch(String s, String p) {
            int ls=s.length();
            int lp=s.length();
            boolean[][] dp=new boolean[ls+1][lp+1];
            for(int i=0 ; i<ls+1; i++){
                for(int j=0 ;j<lp+1 ; j++){
                    dp[i][j]=false;
                }
            }
            dp[0][0]=true;
            for(int j=2 ; j<lp+1 ; j++){
                if(p.charAt(j-1)=='*'){
                    dp[0][j]=dp[0][j-2];
                }
            }
            for(int i=1 ;i<ls+1 ; i++){
                for(int j=1 ; j<lp+1 ; j++){
                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                        dp[i][j]=dp[i-1][j-1];
                    }else if(p.charAt(j-1)=='*'){
                        dp[i][j]=dp[i][j-2]||   dp[i][j-1]     ||( (s.charAt(i-1)==p.charAt(j-2)  || p.charAt(j-2)=='.') &&  dp[i-1][j]);
                    }
                }
            }
            return dp[ls][lp];
        }
}
