package medium;//Given an array of strings, group anagrams together.
//
//        Example:
//
//        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Output:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        Note:
//
//        All inputs will be in lowercase.
//        The order of your output does not matter.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> dict=new HashMap<>();
        for(String s:strs){
            String sSorted=sortString(s);
            if(dict.containsKey(sSorted)){
                dict.get(sSorted).add(s);
            }else{
                List<String> temp=new ArrayList<>();
                temp.add(s);
                dict.put(sSorted , temp );
            }
        }
        List<List<String>> ans= new ArrayList<>();
        for(List<String>  temp :dict.values()){
            ans.add(temp);
        }
        return ans;
    }
    private String sortString(String s){
        char[] temp=s.toCharArray();
        Arrays.sort(temp);
        return String.valueOf(temp);
    }
}
