package fb.medium;
//
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
//
//        Note:
//
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//
//        Input:
//        s = "catsanddog"
//        wordDict = ["cat", "cats", "and", "sand", "dog"]
//        Output:
//        [
//        "cats and dog",
//        "cat sand dog"
//        ]
//        Example 2:
//
//        Input:
//        s = "pineapplepenapple"
//        wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//        Output:
//        [
//        "pine apple pen apple",
//        "pineapple pen apple",
//        "pine applepen apple"
//        ]
//        Explanation: Note that you are allowed to reuse a dictionary word.
//        Example 3:
//
//        Input:
//        s = "catsandog"
//        wordDict = ["cats", "dog", "sand", "and", "cat"]
//        Output:
//        []


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int l=s.length();
        Set<String> dict=new HashSet<>();
        for(String word:wordDict){
            dict.add(word);
        }
        //Set<String> dict=new HashSet<>(wordDict);  why we can't do this? the whole List will becomes key
        List<String> ans=new ArrayList<>();
        recur(s , 0 , l , dict , new ArrayList<String>() ,   ans);
        return ans;
    }
    private void recur(String s  , int idx , int l , Set<String> dict , List<String> candidate ,List<String> ans){
        if(idx==l){
            ans.add(String.join(" " , candidate));
            return ;
        }
        for(int i=idx ; i<l ;  i++){
            if(dict.contains(s.substring(idx , i+1))){
                candidate.add(s.substring(idx , i+1));
                recur(s , i+1  , l , dict , candidate , ans);
                candidate.remove(candidate.size()-1);
            }
        }

    }
//    TLE 几个意思？？？？

}
