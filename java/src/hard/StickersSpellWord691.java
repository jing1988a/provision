package hard;//We are given N different types of stickers. Each sticker has a lowercase English word on it.
//
//        You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.
//
//        You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
//
//        What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.
//
//        Example 1:
//
//        Input:
//
//        ["with", "example", "science"], "thehat"
//        Output:
//
//        3
//        Explanation:
//
//        We can use 2 "with" stickers, and 1 "example" sticker.
//        After cutting and rearrange the letters of those stickers, we can form the target "thehat".
//        Also, this is the minimum number of stickers necessary to form the target string.
//        Example 2:
//
//        Input:
//
//        ["notice", "possible"], "basicbasic"
//        Output:
//
//        -1
//        Explanation:
//
//        We can't form the target "basicbasic" from cutting letters from the given stickers.
//        Note:
//
//        stickers has length in the range [1, 50].
//        stickers consists of lowercase English words (without apostrophes).
//        target has length in the range [1, 15], and consists of lowercase English letters.
//        In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was chosen as a concatenation of two random words.
//        The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 35ms on average.


//题目大意：给定n个stickers，每个stickers可以使用无数次。现在要将stickers拼成target（就是拆分stickers中的字母来凑成target），求用最少的使用次数（使用同一个sticker两次次数算2）使得stickers可以组成target。
//
//        思路：
//
//        这题对时间要求很高。
//
//        要注意剪枝。很重要的一点就是只保留target的字符，然后去除被包含的所有stickers.
//
//        比如target为abc,stickers=[‘afg’,’abf’]只保留stickers=[‘a’,’ab’]，第一个被第二个包含，因此stickers=[‘ab’]，这样能保证结果不差，而需要搜索的空间大大减少。
//
//        然后BFS即可。

import java.util.*;

public class StickersSpellWord691 {
    //1 clean input
    //2 bfs
    public int minStickers(String[] stickers, String target) {
        Map<Character , Integer> tCharCount=new HashMap<>();
        List<Map<Character , Integer>> stickersCharCount=new ArrayList<>();
        tCharCount=getCharCount(target);
        for(String s:stickers){
            stickersCharCount.add(getCharCount(s));
        }
        for(Map<Character , Integer> sCount :stickersCharCount){
            removeUselessChar(sCount , tCharCount);
        }
        List<String> q=new ArrayList();
        Set<String> visited=new HashSet<>();
        visited.add(target);
        q.add(target);
        int ans=1;
        while(!q.isEmpty()){
            List<String> p=new ArrayList<>();
            for(String t: q){
                for(Map<Character , Integer>  sCount: stickersCharCount ){
                    String nextT=getNextT(sCount , t);
                    if(nextT.length()==0){
                        return ans;
                    }
                    if(nextT.length()==t.length()){
                        continue;
                    }
                    if(!visited.contains(nextT)){
                        p.add(nextT);
                        visited.add(nextT);
                    }
                }
            }
            ans++;
            q=p;
        }
        return -1;
    }


    private String getNextT(Map<Character , Integer> sCount, String t){
        Map<Character , Integer> tCount=getCharCount(t);
        StringBuilder sb=new StringBuilder();
        for(Character c:tCount.keySet()){
            int tc=tCount.get(c);
            int sc=sCount.getOrDefault(c , 0);
            for(int i=0 ; i<tc-sc;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private  Map<Character , Integer> getCharCount(String str){
        Map<Character ,Integer> sCount=new HashMap<>();
        for(char c:str.toCharArray()){
            sCount.put(c , sCount.getOrDefault(c , 0)+1);
//            if(sCount.containsKey(c)){
//                sCount.put(c , sCount.get(c)+1);
//            }else{
//                sCount.put(c , 1);
//            }
        }
        return sCount;
    }

    private void removeUselessChar(Map<Character , Integer> sCount , Map<Character , Integer> tCount){
        Set<Character> toRemove=new HashSet();
        for(Character c: sCount.keySet()){
            if(!tCount.containsKey(c)){
                toRemove.add(c);
            }else{
                sCount.put(c , Math.min(sCount.get(c) , tCount.get(c)));
            }
        }
        for(Character c:toRemove){
            sCount.remove(c);
        }

    }


    static public void main(String[] arts){
        StickersSpellWord691 test=new StickersSpellWord691();
        String[] stickers={"with","example","science"};
        String t="thehat";
        System.out.println(test.minStickers(stickers , t));
    }



}
