package fb.easy;//Given two binary strings, return their sum (also a binary string).
//
//        The input strings are both non-empty and contains only characters 1 or 0.
//
//        Example 1:
//
//        Input: a = "11", b = "1"
//        Output: "100"
//        Example 2:
//
//        Input: a = "1010", b = "1011"
//        Output: "10101"



public class AddBinary67 {
    public String addBinary(String a, String b) {
        StringBuilder ans=new StringBuilder();
        StringBuilder aBuilder=new StringBuilder(a).reverse();
        StringBuilder bBuilder=new StringBuilder(b).reverse();
        int la=aBuilder.length();
        int lb=bBuilder.length();
        int i=0;
        int cur=0;
        while (i<la || i<lb){
            if(i<la){
                cur+=Character.getNumericValue(aBuilder.charAt(i));
            }
            if(i<lb){
                cur+=Character.getNumericValue(bBuilder.charAt(i));
            }
            ans.append(String.valueOf(cur%2));
            cur=cur/2;
            i++;
        }
        if(cur==1){
            ans.append(String.valueOf(cur));
        }
        return ans.reverse().toString();
    }
}
