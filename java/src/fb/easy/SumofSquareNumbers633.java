package fb.easy;

//Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
//
//        Example 1:
//        Input: 5
//        Output: True
//        Explanation: 1 * 1 + 2 * 2 = 5
//        Example 2:
//        Input: 3
//        Output: False

import java.util.HashSet;
import java.util.Set;

// can a and be equal???
public class SumofSquareNumbers633 {
    public boolean judgeSquareSum(int c) {
        Set<Integer> squares=new HashSet<>();
        int i=0;
        int cur=0;
        while(cur<=c){
            squares.add(cur);
            if(squares.contains(c-cur)){
                return true;
            }
            i++;
            cur=i*i;
        }
        return false;
    }
    public boolean judgeSquareSumBruteForce(int c) {
        for(int i=0 ; i<=c ; i++){
            for(int j=i ; j<=c ; j++){
                int temp=i*i+j*j;
                if(temp==c){
                    return true;
                }
                if(temp>c){
                    break;
                }
            }
        }
        return false;

    }
}
