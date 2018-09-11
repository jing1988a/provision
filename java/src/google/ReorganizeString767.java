package google;
//Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
//
//        If possible, output any possible result.  If not possible, return the empty string.
//
//        Example 1:
//
//        Input: S = "aab"
//        Output: "aba"
//        Example 2:
//
//        Input: S = "aaab"
//        Output: ""
//        Note:
//
//        S will consist of lowercase letters and have length in range [1, 500].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReorganizeString767 {
    public String reorganizeString(String S) {
        int l=S.length();
        Map<Character , Integer> charCount=new HashMap<>();
        for(char c:S.toCharArray()){
            charCount.put(c , charCount.getOrDefault(c , 0)+1);
        }
        ArrayList<Map.Entry<Character , Integer>> cCount=new ArrayList<>(charCount.entrySet());
        cCount.sort((x , y)->charCount.get(y.getKey())-charCount.get(x.getKey()));
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character , Integer>  e:  cCount){
            for(int i=0 ; i<e.getValue() ; i++){
                sb.append(e.getKey());
            }
        }
        int mid=l/2;
        int flag=l%2;
        int rightIdx=mid;
        if(flag==1){
            rightIdx=mid+1;
        }
        if(sb.charAt(rightIdx)==sb.charAt(0)){
            return "";
        }else{
            StringBuilder ans=new StringBuilder();
            int left=0;
            int right=rightIdx;
            while(right!=l){
                ans.append(sb.charAt(left));
                ans.append(sb.charAt(right));
                left++;
                right++;
            }
            if(left!=rightIdx){
                ans.append(sb.charAt(left));
            }
            return ans.toString();
        }
    }



    static public void main(String[] str){
        ReorganizeString767 test=new ReorganizeString767();
        test.reorganizeString("aab");
    }

}
