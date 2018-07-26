//Input: "aba"
//        Output: True
//        Example 2:
//        Input: "abca"
//        Output: True
//        Explanation: You could delete the character 'c'.
public class ValidPalinII680 {
    public boolean validPalindrome(String s) {
        int end=s.length()-1;
        if(end<1){return true;}
        int start=0;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return isPalin(s.substring(0,start)+s.substring(start+1 )) ||   isPalin(s.substring(0,end)+s.substring(end+1));
            }
            start++;
            end--;
        }
        return true;
    }
    private boolean isPalin(String s){
        String reversed=new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
