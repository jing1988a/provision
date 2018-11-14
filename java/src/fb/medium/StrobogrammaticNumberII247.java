package fb.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//        Find all strobogrammatic numbers that are of length = n.
//
//        Example:
//
//        Input:  n = 2
//        Output: ["11","69","88","96"]
public class StrobogrammaticNumberII247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans=new ArrayList<>();
        Map<Character , Character> d1=new HashMap<>();
        d1.put('0' , '0');
        d1.put('1' , '1');
        d1.put('6' , '9');
        d1.put('8' , '8');
        d1.put('9' , '6');
        // Map<String , String> d2=new HashMap<>();
        // d2.put("0" , "0");
        // d2.put("1" , "1");
        // d2.put("8" , "8");
        List<String> left=new ArrayList<>();
        dfs(n/2  , new StringBuilder()  , left,  d1);
        if(n%2==1){
            String[] word={"0" , "1" , "8"};
            for(String m:word){
                for(String l:left){
                    StringBuilder r=new StringBuilder();
                    for(char c: l.toCharArray()){
                        r.append(d1.get(c));
                    }
                    ans.add(l+m+r.reverse().toString());
                }
            }
            return ans;
        }else{

            for(String l:left){
                StringBuilder r=new StringBuilder();
                for(char c: l.toCharArray()){
                    r.append(d1.get(c));
                }
                ans.add(l+r.reverse().toString());
            }
            return ans;
        }

    }


    private void dfs(int n , StringBuilder candidate ,List<String> ans , Map<Character  , Character> d){
        if(n==0){
            if (  candidate.length()>0  &&   candidate.charAt(0) == '0') {
                return;
            }//这个很重要啊！！！
            ans.add(candidate.toString());
            return;
        }
        for(Character s:d.keySet()){
            candidate.append(s);
            dfs(n-1 , candidate , ans , d);
            candidate.deleteCharAt(candidate.length()-1);
        }
    }
}
