package fb.medium;
//Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//        Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//        Note: You are not suppose to use the library's sort function for this problem.
//
//        Example:
//
//        Input: [2,0,2,1,1,0]
//        Output: [0,0,1,1,2,2]
//        Follow up:
//
//        A rather straight forward solution is a two-pass algorithm using counting sort.
//        First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
//        Could you come up with a one-pass algorithm using only constant space?
//



public class SortColors75 {
    public void sortColors(int[] nums) {
        int l=nums.length;
        if(l<2){return;}
        int idx0=0;
        int idx1=0;
        for(int i=0 ; i<l ; i++){
            if(nums[i]==0){
                nums[i]=2;
                nums[idx1]=1;
                idx1++;
                nums[idx0]=0;
                idx0++;
            }else if(nums[i]==1){
                nums[i]=2;
                nums[idx1]=1;
                idx1++;
            }
        }
        return ;
    }
}
