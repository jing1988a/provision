package eight_hundred_plus;

import java.util.HashMap;
import java.util.Map;

//There are two types of soup: type A and type B. Initially we have N ml of each type of soup. There are four kinds of operations:
//
//        Serve 100 ml of soup A and 0 ml of soup B
//        Serve 75 ml of soup A and 25 ml of soup B
//        Serve 50 ml of soup A and 50 ml of soup B
//        Serve 25 ml of soup A and 75 ml of soup B
//        When we serve some soup, we give it to someone and we no longer have it.  Each turn, we will choose from the four operations with equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as we can.  We stop once we no longer have some quantity of both types of soup.
//
//        Note that we do not have the operation where all 100 ml's of soup B are used first.
//
//        Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.
//
//
//
//        Example:
//        Input: N = 50
//        Output: 0.625
//        Explanation:
//        If we choose the first two operations, A will become empty first. For the third operation, A and B will become empty at the same time. For the fourth operation, B will become empty first. So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
//
//        Notes:
//
//        0 <= N <= 10^9.
//        Answers within 10^-6 of the true value will be accepted as correct.
public class SoupServings808 {

    public double soupServings(int N) {
        if(N>14000){return 1;}
        Map<String , Double> dict=new HashMap<>();
        return recur(N , N , dict);
    }
    private double recur(int A , int B , Map<String , Double> dict){
        if(A<=0 &&B<=0){return 0.5;}
        if(A<=0){return 1;}
        if(B<=0){return 0;}
        if(dict.containsKey(String.valueOf(A)+'_'+String.valueOf(B))){
            return dict.get(String.valueOf(A)+'_'+String.valueOf(B));
        }
        double ans=0.25*(recur(A-100 , B , dict)+recur(A-75 , B-25 , dict)+recur(A-50 , B-50 , dict)  +recur(A-25 , B-75  , dict) );
        dict.put(String.valueOf(A)+'_'+String.valueOf(B) , ans);
        return ans;

    }
}
