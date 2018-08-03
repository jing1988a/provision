package medium;//Implement pow(x, n), which calculates x raised to the power n (xn).
//
//        Example 1:
//
//        Input: 2.00000, 10
//        Output: 1024.00000
//        Example 2:
//
//        Input: 2.10000, 3
//        Output: 9.26100
//        Example 3:
//
//        Input: 2.00000, -2
//        Output: 0.25000
//        Explanation: 2-2 = 1/22 = 1/4 = 0.25
//        Note:
//
//        -100.0 < x < 100.0
//        n is a 32-bit signed integer, within the range [−231, 231 − 1]
//



public class PowXN50 {
    public double myPow(double x, int n) {
        if(n==0){return 1;}
        if(n<0){
            return 1.0/realPow(x , -n);
        }
        return realPow(x  , n);
    }
    private double realPow(double x ,int n){
        if(n==0){return 1;}
        if(n%2==1){
            return   realPow(x ,  n/2)*realPow(x , n/2)*x;
        }
        return realPow(x ,  n/2)*realPow(x , n/2);

    }


    static public void main(String args[]){
        PowXN50 test= new PowXN50();
        double ans=test.myPow(2.0 , 10);
        System.out.println(ans);
    }
}
