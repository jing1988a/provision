package fb.medium;//Given a string, your task is to count how many palindromic substrings in this string.
//
//        The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//
//        Example 1:
//        Input: "abc"
//        Output: 3
//        Explanation: Three palindromic strings: "a", "b", "c".
//        Example 2:
//        Input: "aaa"
//        Output: 6
//        Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//        Note:
//        The input string length won't exceed 1000.




public class PalinSubStr647 {

    public int countSubstrings(String s) {
        int ans=0;
        int l=s.length();
        for(int i=0 ; i<l ; i++){
            for(int j=i ; j<l ; j++){
                if(isPalin(s.substring(i , j+1))){
                    ans++;
                }
            }
        }
        return ans;
    }
    private boolean isPalin(String s){
        int end=s.length()-1;
        int start=0;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
