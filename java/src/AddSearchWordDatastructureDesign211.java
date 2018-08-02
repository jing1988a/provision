//
//
//Design a data structure that supports the following two operations:
//
//        void addWord(word)
//        bool search(word)
//        search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
//
//        Example:
//
//        addWord("bad")
//        addWord("dad")
//        addWord("mad")
//        search("pad") -> false
//        search("bad") -> true
//        search(".ad") -> true
//        search("b..") -> true
//        Note:
//        You may assume that all words are consist of lowercase letters a-z.


import java.util.HashMap;

public class AddSearchWordDatastructureDesign211 {
    TrieNode root;
    /** Initialize your data structure here. */
    public AddSearchWordDatastructureDesign211() {
        root=new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur=this.root;
        for(char c:word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c , new TrieNode());
            }
            cur=cur.children.get(c);
        }
        cur.isEnd=true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int l=word.length();
        TrieNode cur=this.root;
        return realSearch(word , 0 , l , cur );
    }

    private boolean realSearch(String word , int idx ,int  l , TrieNode cur){
        if(idx==l){return cur.isEnd;}
        char c=word.charAt(idx);
        if(c=='.'){
            for(TrieNode n:cur.children.values()){
                if(realSearch(word  , idx+1 , l , n)){return true;}
            }
        }else{
            if(cur.children.containsKey(c)){
                return realSearch(word , idx+1 , l , cur.children.get(c));
            }
            else{
                return false;
            }
        }
        return false;
    }


    class TrieNode{
        HashMap<Character , TrieNode> children =new HashMap<>();
        boolean isEnd=false;

    }
}
