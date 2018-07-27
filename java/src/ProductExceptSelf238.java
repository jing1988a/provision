//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//        Example:
//
//        Input:  [1,2,3,4]
//        Output: [24,12,8,6]
//        Note: Please solve it without division and in O(n).
//
//        Follow up:
//        Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
public class ProductExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
//        int l=nums.length;
//        int[] leftProduct=new int[l];
//        int[] rightProduct=new int[l];
//        int[] ans=new int[l];
//        int cur=1;
//        for(int i=0 ; i<l ; i++){
//            leftProduct[i]=cur;
//            cur*=nums[i];
//        }
//        cur=1;
//        for(int i=l-1 ; i>-1 ; i--){
//            rightProduct[i]=cur;
//            cur*=nums[i];
//        }
//        for(int i=0 ; i<l; i++){
//            ans[i]=leftProduct[i]*rightProduct[i];
//        }
//        return ans;

        int l=nums.length;

        int[] ans=new int[l];
        int cur=1;
        for(int i=0 ; i<l ; i++){
            ans[i]=cur;
            cur*=nums[i];
        }
        cur=1;
        for(int i=l-1 ; i>-1 ; i--){
            ans[i]*=cur;
            cur*=nums[i];
        }
        return ans;

    }
}
