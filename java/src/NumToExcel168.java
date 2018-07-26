//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//        For example:
//
//        1 -> A
//        2 -> B
//        3 -> C
//        ...
//        26 -> Z
//        27 -> AA
//        28 -> AB
//        ...
//        Example 1:
//
//        Input: 1
//        Output: "A"
//        Example 2:
//
//        Input: 28
//        Output: "AB"
//        Example 3:
//
//        Input: 701
//        Output: "ZY


public class NumToExcel168 {
    public String convertToTitle(int n) {
        StringBuilder ans=new StringBuilder();
        while(n>0){
            ans.append((char)((n-1)%26+(int)'A'));
            n=(n-1)/26;
        }
        return ans.reverse().toString();
    }
}

