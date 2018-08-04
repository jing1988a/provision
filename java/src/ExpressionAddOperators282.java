//Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
//
//        Example 1:
//
//        Input: num = "123", target = 6
//        Output: ["1+2+3", "1*2*3"]
//        Example 2:
//
//        Input: num = "232", target = 8
//        Output: ["2*3+2", "2+3*2"]
//        Example 3:
//
//        Input: num = "105", target = 5
//        Output: ["1*0+5","10-5"]
//        Example 4:
//
//        Input: num = "00", target = 0
//        Output: ["0+0", "0-0", "0*0"]
//        Example 5:
//
//        Input: num = "3456237490", target = 9191
//        Output: []


import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators282 {
    public List<String> addOperators(String num, int target) {
        List<String> ans=new ArrayList<>();
        if(num.length()==0){return ans;}
        return recur(num , target , "" , 1 );
    }
    private List<String> recur(String num , long target , String rightString , long rightVal ){
        List<String> ans=new ArrayList<>();
        if(!isLeadingZero(num) && Long.valueOf(num)*rightVal==target){
            ans.add(num+rightString);
        }
        for(int i=0 ; i<num.length()-1; i++){
            String lnum=num.substring(0 , i+1);
            String rnum=num.substring(i+1);
            if(isLeadingZero(rnum)){continue;}
            String newRightString=rnum+rightString;
            long newRightVal=Long.valueOf(rnum)*rightVal;
            for(String l : recur(lnum  , target-newRightVal , "" , 1)){
                ans.add(l+'+'+newRightString);
            }
            for(String l: recur(lnum , target+newRightVal , "" , 1)){
                ans.add(l+"-"+newRightString);
            }
            for(String l: recur(lnum , target  , "*"+newRightString , newRightVal)){
                ans.add(l);
            }


        }
        return ans;
    }
    private  boolean isLeadingZero(String num){
        return num.length()>1&&num.charAt(0)=='0';
    }
}
