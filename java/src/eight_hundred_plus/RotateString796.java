package eight_hundred_plus;
//We are given two strings, A and B.
//
//        A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
//
//        Example 1:
//        Input: A = 'abcde', B = 'cdeab'
//        Output: true
//
//        Example 2:
//        Input: A = 'abcde', B = 'abced'
//        Output: false
//        Note:
//
//        A and B will have length at most 100.
public class RotateString796 {
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        String candidate=A+A;
//        return KMP(candidate , B);
        return bruteForce(candidate , B);
    }
    private  boolean KMP(String A , String B){
        return true;
    }
    private boolean bruteForce(String A , String B){
        int lA=A.length();
        int lB=B.length();
        if(lA<lB){return false;}
        for(int i=0 ; i<lA-lB+1 ; i++){
            if(A.substring(i  , i+lB).equals(B)){
                return true;
            }
        }
        return false;
    }
    static public void main(String[] gaga){
        RotateString796 test=new RotateString796();
        System.out.println(test.bruteForce("aa" , "a"));
    }
}
