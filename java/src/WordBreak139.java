//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//        Note:
//
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//
//        Input: s = "leetcode", wordDict = ["leet", "code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//        Example 2:
//
//        Input: s = "applepenapple", wordDict = ["apple", "pen"]
//        Output: true
//        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//        Note that you are allowed to reuse a dictionary word.
//        Example 3:
//
//        Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//        Output: false


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int l=s.length();
        if(l==0){return true;}
        boolean[] dp=new boolean[l+1];
        Arrays.fill(dp , false);
        dp[0]=true;
        Set<String>  dict= new HashSet<>();
        for(String word:wordDict){dict.add(word);}
        for(int i=1 ; i<l+1 ; i++){
            for(int j=1 ; j<i+1;j++){
                if(dp[i-j] && dict.contains(s.substring(i-j , i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[l];

    }

}
