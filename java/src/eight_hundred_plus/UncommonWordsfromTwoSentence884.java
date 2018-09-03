package eight_hundred_plus;

//We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
//
//        A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//
//        Return a list of all uncommon words.
//
//        You may return the list in any order.
//
//
//
//        Example 1:
//
//        Input: A = "this apple is sweet", B = "this apple is sour"
//        Output: ["sweet","sour"]
//        Example 2:
//
//        Input: A = "apple apple", B = "banana"
//        Output: ["banana"]
//
//
//        Note:
//
//        0 <= A.length <= 200
//        0 <= B.length <= 200
//        A and B both contain only spaces and lowercase letters.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsfromTwoSentence884 {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String , Integer> dict=new HashMap<>();
        for(String s:A.split(" ")){
            dict.put(s ,  dict.getOrDefault(s , 0)+1);
        }
        for(String s:B.split(" ")){
            dict.put(s ,  dict.getOrDefault(s , 0)+1);
        }
        List<String> ans=new ArrayList<>();
        for(String s:dict.keySet()){
            if(dict.get(s)==1){
                ans.add(s);
            }
        }
        int l=ans.size();
        String[] realAns=new String[l];
        int count=0;
        for(String s:ans){
            realAns[count]=s;
            count++;
        }
        return realAns;
    }



}
