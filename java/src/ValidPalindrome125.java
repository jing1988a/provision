
//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//        Example 1:
//
//        Input: "A man, a plan, a canal: Panama"
//        Output: true
//        Example 2:
//
//        Input: "race a car"
//        Output: false

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        int end=0;
        int start=s.length();
        while(start<end){
            if(Character.isLetterOrDigit(s.charAt(start))==false){
                start++;
            }else if(Character.isLetterOrDigit(s.charAt(end))==false){
                end--;
            }else{
                if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
