package fb.hard;


//Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
//
//        All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
//
//        Example 1:
//
//        Input: s = "aabbcc", k = 3
//        Output: "abcabc"
//        Explanation: The same letters are at least distance 3 from each other.
//        Example 2:
//
//        Input: s = "aaabc", k = 3
//        Output: ""
//        Explanation: It is not possible to rearrange the string.
//        Example 3:
//
//        Input: s = "aaadbbcc", k = 2
//        Output: "abacabcd"
//        Explanation: The same letters are at least distance 2 from each other.

import java.util.*;

public class RearrangeStringkDistanceApart358 {
    public String rearrangeString(String s, int k) {
        if(k==0){
            return s;
        }
        if(s.length()<2){
            return s;
        }
        Map<Character , Integer> charCount=getCharCount(s);
        StringBuilder ans=new StringBuilder();
        if(charCount.size()<k){return "";}
        PriorityQueue<List> pq=new PriorityQueue<>((x , y)->(int)y.get(0)==(int)x.get(0)?((Character)x.get(1)).compareTo((Character)y.get(1)):(int)y.get(0)-(int)x.get(0));
        for(char c: charCount.keySet()){
            List temp=new ArrayList();
            temp.add(charCount.get(c));
            temp.add(c);
            pq.add(temp);
        }
        while(!pq.isEmpty()){
            Set<List> toPush=new HashSet<>();
            for(int i=0 ; i <k ; i++){
                if(pq.isEmpty()){
                    return "";
                }
                List temp=pq.poll();
                char c=(char)temp.get(1);
                int count=(int)temp.get(0);
                if(count-1!=0){
                    List addBack=new ArrayList();
                    addBack.add(count-1);
                    addBack.add(c);
                    toPush.add(addBack);
                }
                ans.append(c);
                if(pq.isEmpty()){
                    if(toPush.isEmpty()) {
                        return ans.toString();
                    }
                }
            }
            for(List t:toPush){
                pq.add(t);
            }
        }
        return ans.toString();

    }
    private Map<Character , Integer> getCharCount(String s){
        Map<Character , Integer> ans=new HashMap<>();
        for(char c:s.toCharArray()){
            ans.put(c , ans.getOrDefault(c , 0)+1);
        }
        return ans;
    }

    static public void main(String[] ha) {
        String s = "abcdabcdabdeac";
        int k = 4;
        RearrangeStringkDistanceApart358 test = new RearrangeStringkDistanceApart358();
        System.out.println(test.rearrangeString(s, k));
    }

//        Input:
//        "abcdabcdabdeac"
//        4
//        Output:
//        "abdcadbcadcbea"
//        Expected:
//        "abcdabcdabcdae"
//         abcdabcdabcdae

}
