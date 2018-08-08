//
//Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
//
//        Example 1:
//
//        Input: "eceba"
//        Output: 3
//        Explanation: t is "ece" which its length is 3.
//        Example 2:
//
//        Input: "ccaabbb"
//        Output: 5
//        Explanation: t is "aabbb" which its length is 5.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringwithAtMostTwoDistinctCharacters159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int l=s.length();
        int end=0;
        int start=0;
        int ans=0;
        Map<Character , Integer> charIdx=new HashMap<>();
        Set<Character> contains=new HashSet<>();
        while(end<l){
            while(end<l && contains.size()<=2 ){
                char c=s.charAt(end);
                contains.add(c);
                charIdx.put(c , end);
                if(contains.size()<=2) {
                    ans = Math.max(ans, end - start + 1);
                }
                end++;
            }
            //get idx and the char to move
            int idx=Integer.MAX_VALUE;
            char toRemove='#';
            //Below for loop is constant because there aer only 26 char
            for(char c: charIdx.keySet()){
                int lastIdx=charIdx.get(c);
                if(lastIdx<idx){
                    idx=lastIdx;
                    toRemove=c;
                }
            }
            start=idx+1;
            contains.remove(toRemove);
            charIdx.remove(toRemove);// 这一步没有就无限循环了 小哥哥！！

        }
        return ans;

    }

    static public void main(String[] args){
        String s="cdaba";
        System.out.println(s.substring(4));
        System.out.println(s.substring(5).equals(""));
//        LongestSubstringwithAtMostTwoDistinctCharacters159 test=new LongestSubstringwithAtMostTwoDistinctCharacters159();
//        int ans=test.lengthOfLongestSubstringTwoDistinct(s);
//        System.out.println(ans);
    }
}
