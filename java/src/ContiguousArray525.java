//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
//
//        Example 1:
//        Input: [0,1]
//        Output: 2
//        Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
//        Example 2:
//        Input: [0,1,0]
//        Output: 2
//        Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//        Note: The length of the given binary array will not exceed 50,000.
//


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContiguousArray525 {
    public int findMaxLength(int[] nums) {
        int l = nums.length;
        int[] temp = new int[l];
        int cur = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                cur--;
            } else {
                cur++;
            }
            temp[i] = cur;
        }
        HashMap<Integer, Integer> balanceIdx = new HashMap<>();
        balanceIdx.put(0, -1);
        int ans = 0;
        for (int i = 0; i < l; i++) {
            if (balanceIdx.containsKey(temp[i])) {
                ans = Math.max(ans, i - balanceIdx.get(temp[i]));
            } else {
                balanceIdx.put(temp[i], i);
            }

        }
        return ans;
//        HashMap<Integer, List<Integer>> balanceIdx = new HashMap<>();
//        for(int i=0 ; i<l ; i++){
//            int balance=temp[i];
//            if(!balanceIdx.containsKey(balance)){
//                List<Integer> idxs=new ArrayList<>();
//                idxs.add(i);
//                balanceIdx.put(balance , idxs);
//            }else{
//                balanceIdx.get(balance).add(i);
//            }
//        }
//        int ans=0;
//        for(Map.Entry<Integer , List<Integer>> e :balanceIdx.entrySet()){
//            int balance=e.getKey();
//            List<Integer> idxs=e.getValue();
//            if(balance==0){
//                ans=Math.max(ans , idxs.get(idxs.size()-1)+1);
//            }else{
//                ans=Math.max(ans , idxs.get(idxs.size()-1)-idxs.get(0));
//            }
//        }
//        return ans;

    }


//    如果 array里 不是只有0 1 呢？？？ 那就先把01 的 Contiguos array 的每一段先找出来 然后再用上面的方法。
    public int findMaxLengthMoreThan01(int[] nums) {
        List<Integer[]> numsList=getParts(nums);
        int ans=0;
        for(Integer[] n:numsList){
            int[] temp=IntegerArrayToIntArray(n);
            ans=Math.max(ans , findMaxLength(temp));
        }
        return ans;
    }
    private List<Integer[]> getParts(int[] nums){
        List<Integer[]> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int i : nums){
            if(i==0 || i==1){
                temp.add(i);
            }else{
                if(!temp.isEmpty()) {
                    ans.add(temp.toArray(new Integer[temp.size()]));
                }
                temp.clear();
            }
        }
        return ans;
    }
    private int[] IntegerArrayToIntArray(Integer[] nums){
        int l=nums.length;
        int[] ans = new int[l];
        for(int i=0 ; i<l ; i++){
            ans[i]=nums[i];
        }
        return ans;
    }


}