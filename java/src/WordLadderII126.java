//
//Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
//
//        Only one letter can be changed at a time
//        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//        Note:
//
//        Return an empty list if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        You may assume no duplicates in the word list.
//        You may assume beginWord and endWord are non-empty and are not the same.
//        Example 1:
//
//        Input:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//
//        Output:
//        [
//        ["hit","hot","dot","dog","cog"],
//        ["hit","hot","lot","log","cog"]
//        ]
//        Example 2:
//
//        Input:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//
//        Output: []
//
//        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
//

import java.util.*;

public class WordLadderII126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        List<List<String>> ans= new ArrayList<>();
        if(!wordSet.contains(endWord)){
            return ans;
        }
        List<List> q=new ArrayList<>();
        List temp=new ArrayList();
        temp.add(beginWord);
        temp.add(new ArrayList<String>(Arrays.asList(beginWord)));
        q.add(temp);
        int l=beginWord.length();
        boolean found=false;
        while(!q.isEmpty()){
            List<String> toRemove=new ArrayList<>();
            List<List> p=new ArrayList<>();
            for(List n:q){
                String curWord=(String) n.get(0);
                List<String> candidate=(List)n.get(1);
                if(curWord.equals(endWord)){
                    ans.add(candidate); // do we need a deepcopy there???
                    found=true;
                }
                if(!found){
                    for(int i=0 ; i<l ; i++){
                        for(char c : "qwertyuiopasdfghjklzxcvbnm".toCharArray()){
                            String nextWord=curWord.substring(0,i)+String.valueOf(c)+curWord.substring(i+1);
                            if(wordSet.contains(nextWord)){
                                toRemove.add(nextWord);
                                List temp1=new ArrayList();
                                temp1.add(nextWord);
                                List<String> newCandidate=new ArrayList<>(candidate);
                                newCandidate.add(nextWord);
                                temp1.add(newCandidate);
                                p.add(temp1);

                            }
                        }
                    }
                }
            }
            if(found){
                break;
            }
            for(String s:toRemove){
                wordSet.remove(s);
            }
            q=p;
        }
        return ans;
    }

}
