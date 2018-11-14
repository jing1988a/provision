package fb.hard;

import java.util.HashMap;
import java.util.Map;

//Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
//        Example 1:
//
//        Input: s = "eceba", k = 2
//        Output: 3
//        Explanation: T is "ece" which its length is 3.
//        Example 2:
//
//        Input: s = "aa", k = 1
//        Output: 2
//        Explanation: T is "aa" which its length is 2.
public class LongestSubstringwithAtMostKDistinctCharacters340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int curCount=0;
        Map<Character , Integer> charIdx=new HashMap<>();
        int start=0;
        int end=0;
        int l=s.length();
        if(k>=l){
            return l;
        }
        int ans=0;
        while (end<l){
            while(end<l && charIdx.size()<=k){
                charIdx.put(s.charAt(end) , end);
                if(charIdx.size()<=k) {
                    ans = Math.max(ans, end - start + 1);
                }
                end++;
            }
            int leftMostIdx=Integer.MAX_VALUE;
            Character toRemove='a';
            for(Character c:charIdx.keySet()){
                if(charIdx.get(c)<leftMostIdx){
                    leftMostIdx=charIdx.get(c);
                    toRemove=c;
                }
            }
            start=leftMostIdx+1;
            charIdx.remove(toRemove);
        }
        return ans;
    }
}
