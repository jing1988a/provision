package fb.easy;//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//        Example 1:
//
//        Input: [3,0,1]
//        Output: 2
//        Example 2:
//
//        Input: [9,6,4,2,3,5,7,0,1]
//        Output: 8


//only one missing? will there be duplicate there???
public class MissingNum268 {
    public int missingNumber(int[] nums) {
        int l=nums.length;
        if(l==0){
            return 0;
        }
        return l*(l+1)/2-sumArray(nums);
    }
    private int sumArray(int[] nums){
        int ans=0;
        for(int  n :nums){
            ans+=n;
        }
        return ans;
    }
}
