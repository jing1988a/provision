package eight_hundred_plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//you have a list of words and a pattern, and you want to know which words in words matches the pattern.
//
//        A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
//
//        (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
//
//        Return a list of the words in words that match the given pattern.
//
//        You may return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//        Output: ["mee","aqq"]
//        Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
//        "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
//        since a and b map to the same letter.
//
//
//        Note:
//
//        1 <= words.length <= 50
//        1 <= pattern.length = words[i].length <= 20
public class FindandReplacePattern890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // can i assume word has same length as pattern???
        List<String> ans=new ArrayList<>();
        for(String s:words){
            if(samePattern(s , pattern)){
                ans.add(s);
            }
        }
        return ans;
    }

    private boolean samePattern(String a , String b){
        Map<Character , Character> aToB=new HashMap<>();
        Map<Character , Character> bToA=new HashMap<>();
        for(int i=0 ; i<a.length() ; i++){
            char ai=a.charAt(i);
            char bi=b.charAt(i);
            if(aToB.containsKey(ai)){
                if(aToB.get(ai)!=bi){
                    return false;
                }
            }
            if(bToA.containsKey(bi)){
                if(bToA.get(bi)!=ai){
                    return false;
                }
            }
            aToB.put(ai , bi);
            bToA.put(bi , ai);

        }
        return true;

    }
}
