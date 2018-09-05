package eight_hundred_plus;
//Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
//
//        For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
//
//        Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.
//
//        What is the length of the shortest reference string S possible that encodes the given words?
//
//        Example:
//
//        Input: words = ["time", "me", "bell"]
//        Output: 10
//        Explanation: S = "time#bell#" and indexes = [0, 2, 5].
//        Note:
//
//        1 <= words.length <= 2000.
//        1 <= words[i].length <= 7.
//        Each word has only lowercase letters.
//        Seen this question in a real interview before?

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortEncodingofWords820 {
    public int minimumLengthEncoding(String[] words) {
        //trie?? backward?
        RevTrie rt=new RevTrie();
        for(String w:words){
            rt.add(w);
        }
        return rt.getLen();
    }
    public class RevTrie{
        TrieNode root=new TrieNode();
        int totalLen=0;
        public void add(String w){

            TrieNode cur=this.root;
            for(int i=w.length()-1 ; i>=0 ; i-- ){
                char c=w.charAt(i);
                if(!cur.chilren.containsKey(c)){
                    cur.chilren.put(c , new TrieNode());
                }
                cur=cur.chilren.get(c);
            }
            cur.isEnd=true;
        }
        public int getLen(){
            TrieNode cur=this.root;
            this.totalLen=0;
            if(cur.chilren.isEmpty()){
                return 0;
            }
            recur(cur , 0);
            return this.totalLen;
        }
        private void recur(TrieNode root   , int l){
            l++;
            if(root.chilren.isEmpty()){
                this.totalLen+=l;
                return ;
            }
            for(TrieNode tn:root.chilren.values()){
                recur(tn , l);
            }
        }



        class TrieNode{
            boolean isEnd=false;
            HashMap<Character , TrieNode> chilren=new HashMap<>();
        }
    }
}
