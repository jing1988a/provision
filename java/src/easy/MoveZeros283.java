package easy;//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//        Example:
//
//        Input: [0,1,0,3,12]
//        Output: [1,3,12,0,0]
//        Note:
//
//        You must do this in-place without making a copy of the array.
//        Minimize the total number of operations.





public class MoveZeros283 {
    public void moveZeroes(int[] nums) {
        int l = nums.length;
        if(l==0){
            return;
        }
        int cur=0;
        for(int n : nums){
            if(n!=0){
                nums[cur]=n;
                cur++;
            }
        }
        while(cur<l){
            nums[cur]=0;
            cur++;
        }
        return;
    }


    static public void main(String[] args){
        MoveZeros283 test=new MoveZeros283();
        int[] a={0,1,0,3,12};
        test.moveZeroes(a);
    }
}
