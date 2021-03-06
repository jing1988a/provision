package fb.medium;


//
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//        The replacement must be in-place and use only constant extra memory.
//
//        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1


import java.util.Arrays;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int l=nums.length;
        if(l<2){
            return;
        }
        int i=l-2;
        while(i>-1 &&nums[i]>=nums[i+1]){
            i--;
        }
        if(i==-1){
            myReverse(nums);
            return;
        }
        int j=l-1;
        while(nums[j]<=nums[i]){
            j--;
        }
        swap(nums , i , j);
        Arrays.sort(nums , i+1 , l);
        return;

    }

    private void swap(int[] nums ,int i ,int  j ){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
    private void myReverse(int[] nums){
        int i=0 ;
        int j=nums.length-1;
        while(i<j){
            swap(nums , i , j );
            i++;
            j--;
        }
    }
}
