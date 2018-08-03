package medium;
//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//        Only one letter can be changed at a time.
//        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//        Note:
//
//        Return 0 if there is no such transformation sequence.
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
//        Output: 5
//
//        Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.
//        Example 2:
//
//        Input:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//
//        Output: 0
//
//        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        int ans = 1;
        List<String> q = new ArrayList<>();
        q.add(beginWord);
        wordSet.remove(beginWord);
        int l = beginWord.length();
        while (!q.isEmpty()) {
            List<String> p = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                String cur = q.get(i);
                if (cur.equals(endWord)) {
                    return ans;
                }
                for (int j = 0; j < l; j++) {
                    for (char c : "qwertyuiopasdfghjklzxcvbnm".toCharArray()) {
                        String s = Character.toString(c);
                        String temp = cur.substring(0, j) + s + cur.substring(j + 1);
                        if (wordSet.contains(temp)) {
                            p.add(temp);
                            wordSet.remove(temp);
                        }
                    }
                }
            }
            q = p;
            ans++;
        }
        return 0;
    }
    
    static public void main(String[] arg){
        WordLadder127 test= new WordLadder127();
        String a="hit";
        String b="cog";
        List<String> dict=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int ans=test.ladderLength(a , b , dict);
        System.out.println(ans);
    }


}

