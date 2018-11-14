package fb.medium;//Given an encoded string, return it's decoded string.
//
//        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//        You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//        Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//        Examples:
//
//        s = "3[a]2[bc]", return "aaabcbc".
//        s = "3[a2[c]]", return "accaccacc".
//        s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
//

import java.util.HashMap;
import java.util.Stack;

public class DecodeString394 {
//    public String decodeString(String s) {
//        HashMap<Integer , Integer> levelCount=new HashMap<>();
//        HashMap<Integer , String>  levelString=new HashMap<>();
//        int level=0;
//        for(char c :s.toCharArray()){
//            if(Character.isDigit(c)){
//                if(!levelCount.containsKey(level)){levelCount.put(level , Character.getNumericValue(c));}
//                else{
//                    levelCount.put(level , levelCount.get(level)*10+Character.getNumericValue(c));
//                }
//            }
//            else if(c=='['){level++;}
//            else if(c==']'){
//                if(levelString.containsKey(level-1)){
//                    String preLevelString=levelString.get(level-1);
//                    preLevelString+=repeat(levelCount.get(level-1) , levelString.get(level) );
//                    levelString.put(level-1 , preLevelString);
//                }else{
//                    levelString.put(level-1 , repeat(levelCount.get(level-1) , levelString.get(level) ));
//                }
//                levelCount.put(level-1 , 0);
//                levelString.put(level , "");
//                level--;
//            }else{
//                if(levelString.containsKey(level)){
//                    levelString.put(level , levelString.get(level)+Character.toString(c));
//                }else{
//                    levelString.put(level , Character.toString(c));
//                }
//            }
//
//        }
//        if(levelString.containsKey(0)){
//            return levelString.get(0);
//        }else{
//            return "";
//        }
//
//    }
//
//    private String repeat(int count , String s){
//        StringBuilder temp=new StringBuilder();
//        for(int i=0 ; i<count ; i++){
//            temp.append(s);
//        }
//        return temp.toString();
//
//    }

    public String decodeString(String s) {
        StringBuilder ans=new StringBuilder();
        int l=s.length();
        int i=0;
        int curRepeat=0;
        String curStr="";
        while(i<l){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                curRepeat=curRepeat*10+Character.getNumericValue(c);
            }
            else if(c=='['){
                int j=i;
                int count=1;
                while(count!=0){
                    j++;
                    if(s.charAt(j)==']'){
                        count--;

                    }else if(s.charAt(j)=='['){
                        count++;
                    }
                }
                curStr=decodeString(s.substring(i+1 , j));
                ans.append(repeat(curRepeat ,curStr ));
                curRepeat=0;
                curStr="";
                i=j;
            }else{
                ans.append(c);
            }
            i++;
        }
        return ans.toString();
    }


    private String repeat(int t , String str){
        StringBuilder res=new StringBuilder();
        for(int i=0 ; i<t ; i++){
            res.append(str);
        }
        return res.toString();
    }
}
