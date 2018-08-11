package hard;//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//        Example 1:
//
//        Input:
//        s = "barfoothefoobarman",
//        words = ["foo","bar"]
//        Output: [0,9]
//        Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
//        The output order does not matter, returning [9,0] is fine too.
//        Example 2:
//
//        Input:
//        s = "wordgoodstudentgoodword",
//        words = ["word","student"]
//        Output: []



// is word has the same length???? this is very important!!!!!

// assume same length

import java.util.*;

public class SubstringConcatenationAllWords30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int l=s.length();
        int n=words.length;
        List<Integer> ans=new ArrayList();
        if(n==0){return ans;}
        int m=words[0].length();
        Map<String , Integer> wordCount=new HashMap();
        for(String w:words){
            if(wordCount.containsKey(w)){
                wordCount.put(w , wordCount.get(w)+1);
            }else{
                wordCount.put(w , 1);
            }
        }
//        Map<String , Integer> candidates=new HashMap(wordCount); //放到外面 每个循环之间就会有干扰。 很皮啊
        for(int i=0 ; i<m;i++){
            //check
            Map<String , Integer> candidates=new HashMap(wordCount);
            int start=i+m-1;
            int end=i+m-1;
            while(end<l && start<l){
                end=Math.max(start , end);
                String temp=s.substring(end-m+1 , end+1);
                if( candidates.containsKey(temp)){
                    if(candidates.get(temp)==1){
                        candidates.remove(temp);
                    }else{
                        candidates.put(temp , candidates.get(temp)-1);
                    }
                    end+=m;
                    if(candidates.isEmpty()){
                        ans.add(start-m+1);
                        candidates.put(s.substring(start-m+1 , start+1) , 1);
                        start+=m;
                    }

                }else{
                    String sTemp=s.substring(start-m+1 , start+1);
                    if(wordCount.containsKey(sTemp)){
                        if(candidates.containsKey(sTemp)){
                            candidates.put(sTemp , candidates.get(sTemp)+1);
                        }else{
                            candidates.put(sTemp , 1);
                        }

                    }
                    start+=m;


                }
            }
        }
        return ans;
    }

    static public void main(String[]  args){
        String s="aaa";
        String[] words=  {"aa","aa"};
        SubstringConcatenationAllWords30 test=new SubstringConcatenationAllWords30();
        List<Integer> ans =test.findSubstring(s  , words);
        System.out.println(ans);
    }


}
