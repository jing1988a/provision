
//Given two strings s and t, determine if they are both one edit distance apart.
//
//        Note:
//
//        There are 3 possiblities to satisify one edit distance apart:
//
//        Insert a character into s to get t
//        Delete a character from s to get t
//        Replace a character of s to get t
//        Example 1:
//
//        Input: s = "ab", t = "acb"
//        Output: true
//        Explanation: We can insert 'c' into s to get t.
//        Example 2:
//
//        Input: s = "cab", t = "ad"
//        Output: false
//        Explanation: We cannot get t from s by only one step.
//        Example 3:
//
//        Input: s = "1203", t = "1213"
//        Output: true
//        Explanation: We can replace '0' with '1' to get t.


public class OneEditDistance161 {
    public boolean isOneEditDistance(String s, String t) {
        int ls=s.length();
        int lt=t.length();
        if(ls==lt+1){
            return checkAddOne(s , t);
        }else if (lt==ls+1){
            return checkAddOne(t , s);
        }else if(lt==ls){
            return checkChangeOne(s , t);
        }
        return false;
    }

    private boolean checkAddOne(String s , String t){
        int l=s.length();
        int i=0;
        int j=0;
        boolean diff=false;
        while(j<l-1){
            if(s.charAt(i)!=t.charAt(j)){
                if(diff){
                    return false;
                }
                diff=true;
                i++;
                continue;
            }
            i++;
            j++;
        }
        return true;
    }

    private boolean checkChangeOne(String s ,String t){
        int l=s.length();
        int i=0 ;
        boolean diff=false;
        while(i<l){
            if(s.charAt(i)!=t.charAt(i)){
                if(diff){
                    return false;
                }
                diff=true;
            }
            i++;
        }
        return diff;
    }
}
