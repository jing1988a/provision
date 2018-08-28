package fb.medium;



//Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
//
//        Return the quotient after dividing dividend by divisor.
//
//        The integer division should truncate toward zero.
//
//        Example 1:
//
//        Input: dividend = 10, divisor = 3
//        Output: 3
//        Example 2:
//
//        Input: dividend = 7, divisor = -3
//        Output: -2
//        Note:
//
//        Both dividend and divisor will be 32-bit signed integers.
//        The divisor will never be 0.
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
//


public class DivideTwoIntegers29 {

    public int divide(int dividend, int divisor) {
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        int flag=1;
        if(dividend<0){
            flag*=-1;
        }
        if(divisor<0){
            flag*=-1;
        }
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        int ans=0;
        while(dividend>=divisor){
            int count=1;
            int cur=divisor;
            while(dividend>=2*cur){
                cur*=2;
                count*=2;
            }
            ans+=count;
            dividend-=cur;
        }
        return ans*flag;
    }
}
