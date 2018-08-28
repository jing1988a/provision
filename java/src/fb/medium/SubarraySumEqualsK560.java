package fb.medium;


//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
//
//        Example 1:
//        Input:nums = [1,1,1], k = 2
//        Output: 2
//        Note:
//        The length of the array is in range [1, 20,000].
//        The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
//

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount=new HashMap<>();
        sumCount.put(0  ,1);
        int curSum=0;
        int ans=0;
        for(int n:nums){
            curSum+=n;
            if(sumCount.containsKey(curSum-k)){ans+=sumCount.get(curSum-k);}
            sumCount.put(curSum , sumCount.getOrDefault(curSum , 0)+1);
//            if(sumCount.containsKey(curSum)){
//                sumCount.put(curSum , sumCount.get(curSum)+1);
//            }else{
//                sumCount.put(curSum , 1);
//            }
        }
        return ans;
    }

    static  public  void  main(String[] arts){
        SubarraySumEqualsK560 test=new SubarraySumEqualsK560();
        int[] a={1 , 1 , 1};
        System.out.println(test.subarraySum(a , 2));
    }
}

