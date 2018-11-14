package eight_hundred_plus;

import java.util.Arrays;

//Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
//
//        Return true if and only if we can do this in a way such that the resulting number is a power of 2.
//
//
//
//        Example 1:
//
//        Input: 1
//        Output: true
//        Example 2:
//
//        Input: 10
//        Output: false
//        Example 3:
//
//        Input: 16
//        Output: true
//        Example 4:
//
//        Input: 24
//        Output: false
//        Example 5:
//
//        Input: 46
//        Output: true
//
//
//        Note:
//
//        1 <= N <= 10^9
public class ReorderedPowerof2869 {
    public boolean reorderedPowerOf2(int N) {
        int[] countN=myCount(N);
        for(int i=0 ; i<31 ; i++){
            int candidate=(1<<i);
            // if(candidate>N){
            //     break;
            // }   不需要这个，   candidate 是可以比N 大得
            if(Arrays.equals(countN  , myCount(candidate))){
                return true;
            }
        }
        return false;

    }
    private int[] myCount(int N){
        int[] ans=new int[10];
        while(N>0){
            ans[N%10]++;
            N/=10;
        }
        return ans;
    }
}
