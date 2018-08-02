//
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//        Example 1:
//
//        Input: num1 = "2", num2 = "3"
//        Output: "6"
//        Example 2:
//
//        Input: num1 = "123", num2 = "456"
//        Output: "56088"
//        Note:
//
//        The length of both num1 and num2 is < 110.
//        Both num1 and num2 contain only digits 0-9.
//        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplyStrings43 {
    public String multiply(String num1, String num2) {
        StringBuilder a=new StringBuilder(num1);
        StringBuilder b=new StringBuilder(num2);
        a.reverse();
        b.reverse();
        List<List<Integer>> tempAns= new ArrayList<>();
        for(int i=0 ; i<a.length() ; i++){
            List<Integer> temp=new ArrayList<>();
            for(int x=0 ;x<i ; x++){
                temp.add(0);
            }
            int cur=0;
            for(int j=0 ; j<b.length() ; j++){
                cur+=Character.getNumericValue(a.charAt(i))*Character.getNumericValue(b.charAt(j));
                temp.add(cur%10);
                cur/=10;
            }
            if(cur!=0){
                temp.add(cur);
            }
            tempAns.add(temp);
        }

        List<Integer> ans=new ArrayList<>();
        int cur=0;
        for(int j=0 ; j<tempAns.get(tempAns.size()-1).size() ; j++){
            for(int i=0 ; i<tempAns.size() ; i++){
                if(j<tempAns.get(i).size()){
                    cur+=tempAns.get(i).get(j);
                }
            }
            ans.add(cur%10);
            cur/=10;
        }
        if(cur>0){
            ans.add(cur);
        }
        Collections.reverse(ans);
        if(ans.size()==0 || ans.get(0)==0){return "0";}
        StringBuilder realAns=new StringBuilder();
        for(Integer i : ans){
            realAns.append(i);
        }
        return realAns.toString();
    }
}
