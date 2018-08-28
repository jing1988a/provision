package fb.hard;//Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
//
//        Example 1:
//
//        Input: ["abcd","dcba","lls","s","sssll"]
//        Output: [[0,1],[1,0],[3,2],[2,4]]
//        Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
//        Example 2:
//
//        Input: ["bat","tab","cat"]
//        Output: [[0,1],[1,0]]
//        Explanation: The palindromes are ["battab","tabbat"]
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs336 {
//    public List<List<Integer>> palindromePairs(String[] words) {
//        int l=words.length;
//        List<List<Integer>> ans= new ArrayList();
//        for(int i=0 ; i<l ; i++){
//            for(int j=0 ; j<l ; j++){
//                if(i==j){continue;}
//                if(isPalin(words[i]+words[j])){
//                    List<Integer> temp=new ArrayList();
//                    temp.add(i);
//                    temp.add(j);
//                    ans.add(temp);
//                }
//            }
//        }
//        return ans;
//    }

// 上面那个 肯定会timeout 啦。。。。。。


    // can i assume on duplicate????
    public List<List<Integer>> palindromePairs(String[] words) {
        int l=words.length;
        List<List<Integer>> ans= new ArrayList();
        Map<String , Integer> wordIdx=new HashMap();
        for(int i=0; i<l ; i++){
            wordIdx.put(words[i] , i);
        }
        for(String w:words){
            int n=w.length();
            if(n==0){continue;}
            int start=0;
            int end=0;
            while(start<=end){
                String temp=w.substring(start , end);
                String revTemp=new StringBuilder(temp).reverse().toString();
                if(wordIdx.containsKey(revTemp) && isPalin(w.substring(start==0? end: 0 , start==0? n:start )) && wordIdx.get(revTemp)!=wordIdx.get(w)){
                    List<Integer> a=new ArrayList();
                    if(start==0) {
                        a.add(wordIdx.get(w));
                        a.add(wordIdx.get(revTemp));
                    }else{
                        a.add(wordIdx.get(revTemp));
                        a.add(wordIdx.get(w));
                    }
                    ans.add(a);
                }
                if(end<n){
                    end++;
                }else{
                    start++;
                }
            }
        }
        return ans;


    }

    private boolean isPalin(String str){
        if(str.length()==0){return true;}
        return str.equals(new StringBuilder(str).reverse().toString());
    }


    static public void main(String[] str){
        PalindromePairs336 test=new PalindromePairs336();
        String[] words={"a" , ""};
        List<List<Integer>> ans= test.palindromePairs(words);
        System.out.println(ans);

    }


//
//    Input:
//            ["abcd","dcba","lls","s","sssll"]
//    Output:
//            [[0,1],[1,0],[2,3],[4,2]]
//    Expected:
//            [[0,1],[1,0],[3,2],[2,4]]
}
