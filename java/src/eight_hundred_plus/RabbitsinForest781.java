package eight_hundred_plus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
//
//        Return the minimum number of rabbits that could be in the forest.
//
//        Examples:
//        Input: answers = [1, 1, 2]
//        Output: 5
//        Explanation:
//        The two rabbits that answered "1" could both be the same color, say red.
//        The rabbit than answered "2" can't be red or the answers would be inconsistent.
//        Say the rabbit that answered "2" was blue.
//        Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
//        The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
//
//        Input: answers = [10, 10, 10]
//        Output: 11
//
//        Input: answers = []
//        Output: 0
//        Note:
//
//        answers will have length at most 1000.
//        Each answers[i] will be an integer in the range [0, 999].
public class RabbitsinForest781 {
    public int numRabbits(int[] answers) {
        Map<Integer , Integer> dict=new HashMap<>();
        int ans=0;
        for(int a:answers){
            if(!dict.containsKey(a)  || dict.get(a)==0){
                ans+=a+1;
                dict.put(a , a);
            }else{
                dict.put(a , dict.get(a)-1);
            }
        }
        return ans;
//        Set<Integer> seen=new HashSet<>();
//        int ans=0;
//        for(int a: answers){
//            if(a==0){
//                ans++;
//            }
//            else if(!seen.contains(a)){
//                ans+=a+1;
//                seen.add(a);
//            }
//        }
//        return ans;
    }
//    Input:
//            [0,0,1,1,1]
//    Output:
//            4
//    Expected:
//            6
}
