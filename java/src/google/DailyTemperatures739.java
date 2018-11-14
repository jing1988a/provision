package google;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
//
//        For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//
//        Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Map<Integer , Integer> tempIdx=new HashMap<>();
        for(int i=temperatures.length-1  ; i>=0 ; i--){
            int candidate=Integer.MAX_VALUE;
            for(int k:tempIdx.keySet()){
                if(k>temperatures[i]){
                    candidate=Math.min(candidate , tempIdx.get(k)-i);
                }
            }
            if(candidate==Integer.MAX_VALUE){
                ans[i]=0;
            }else{
                ans[i]=candidate;
            }
            tempIdx.put(temperatures[i] , i);

        }
        return ans;
    }
}
