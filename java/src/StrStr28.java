//
//Implement strStr().
//
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
//        Example 2:
//
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



public class StrStr28 {
    public int strStr(String haystack, String needle) {
        int ln=needle.length();
        if(ln==0){return 0;}
        int lh=haystack.length();
//        if(ln<ln){return -1;}
        for(int i=0 ; i<lh-ln+1; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(isPrefix(haystack , i , needle)==true){
                    return i;
                }
            }
        }
        return -1;
    }
    private  boolean isPrefix(String a , int idx , String needle){
        for(int i=0 ; i<needle.length(); i++){
            if (needle.charAt(i)!=a.charAt(idx+i)){
                return false;
            }
        }
        return true;
    }
}
