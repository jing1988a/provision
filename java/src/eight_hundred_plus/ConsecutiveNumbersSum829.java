package eight_hundred_plus;
//Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
//
//        Example 1:
//
//        Input: 5
//        Output: 2
//        Explanation: 5 = 5 = 2 + 3
//        Example 2:
//
//        Input: 9
//        Output: 3
//        Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
//        Example 3:
//
//        Input: 15
//        Output: 4
//        Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
//        Note: 1 <= N <= 10 ^ 9.


public class ConsecutiveNumbersSum829 {
    public int consecutiveNumbersSum(int N) {
        int c=1;
        int ans=0;
        while(N/c>=(c/2+c%2 )){
            if(c%2==1){
                if(N%c==0){
                    ans++;
                }
            }else{
                if( N==((N/c)*c+c/2) ){
                    ans++;
                }
            }
            c++;
        }
        return ans;
    }
}
