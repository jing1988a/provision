package fb.medium;//class Trie {
//    Node root=new Node();
//
//    /** Initialize your data structure here. */
//    public Trie() {
//
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        Node cur=this.root;
//        for(char c:word.toCharArray()){
//            if(!cur.dict.containsKey(c)){
//                cur.dict.put(c , new Node());
//            }
//            cur=cur.dict.get(c);
//        }
//        cur.isEnd=true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        Node cur=this.root;
//        // for(String c:word){      for-each not applicable to expression type
//        for(char c:word.toCharArray()){
//            if(!cur.dict.containsKey(c)){
//                return false;
//            }
//            cur=cur.dict.get(c);
//        }
//        return cur.isEnd;
//
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        Node cur=this.root;
//        for(char c:prefix.toCharArray()){
//            if(!cur.dict.containsKey(c)){
//                return false;
//            }
//            cur=cur.dict.get(c);
//        }
//        return true;
//
//    }
//}
//
//
//class Node{
//    HashMap<Character , Node> dict=new HashMap<Character , Node>();
//    boolean isEnd=false;
//}



//Implement a trie with insert, search, and startsWith methods.
//
//        Example:
//
//        Trie trie = new Trie();
//
//        trie.insert("apple");
//        trie.search("apple");   // returns true
//        trie.search("app");     // returns false
//        trie.startsWith("app"); // returns true
//        trie.insert("app");
//        trie.search("app");     // returns true
//        Note:
//
//        You may assume that all inputs are consist of lowercase letters a-z.
//        All inputs are guaranteed to be non-empty strings.

import java.util.HashMap;
import java.util.List;

public class ImplementTrie208 {

    /** Initialize your data structure here. */
    Node root=new Node();
    public ImplementTrie208() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur=this.root;
        for(char c:word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c , new Node());
            }
            cur=cur.children.get(c);
        }
        cur.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur=this.root;
        for(char c:word.toCharArray()){
            if(!cur.children.containsKey(c)){return false;}
            cur=cur.children.get(c);
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur=this.root;
        for(char c:prefix.toCharArray()){
            if(!cur.children.containsKey(c)){return false;}
            cur=cur.children.get(c);
        }
        return true;
    }

    class Node{
        HashMap<Character , Node> children=new HashMap<>();
        boolean isEnd=false;
    }
}
