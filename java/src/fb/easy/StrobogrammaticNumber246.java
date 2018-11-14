package fb.easy;

import java.util.HashMap;
import java.util.Map;

//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//        Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//
//        Example 1:
//
//        Input:  "69"
//        Output: true
//        Example 2:
//
//        Input:  "88"
//        Output: true
//        Example 3:
//
//        Input:  "962"
//        Output: false
public class StrobogrammaticNumber246 {
    public boolean isStrobogrammatic(String num) {
        int l=num.length();
        if(l==0){return true;}
        Map<Character , Character> pairs=new HashMap<>();
        pairs.put('6' , '9');
        pairs.put('9' , '6');
        pairs.put('8' , '8');
        pairs.put('1' , '1');
        pairs.put('0' , '0');
        int i=0 ;
        int j=l-1;
        while(i<=j){
            if(pairs.containsKey(num.charAt(i))  && pairs.containsKey(num.charAt(j)) && pairs.get(num.charAt(i))==num.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
