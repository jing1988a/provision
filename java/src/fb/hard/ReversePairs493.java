package fb.hard;//
//Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
//
//        You need to return the number of important reverse pairs in the given array.
//
//        Example1:
//
//        Input: [1,3,2,3,1]
//        Output: 2
//        Example2:
//
//        Input: [2,4,3,5,1]
//        Output: 3
//        Note:
//        The length of the given array will not exceed 50,000.
//        All the numbers in the input array are in the range of 32-bit integer.


import java.util.Arrays;
import java.util.List;

public class ReversePairs493 {
    public int reversePairsEasy(int[] nums) {
        int l=nums.length;
        int ans=0;
        for(int i=0 ; i<l-1 ; i++){
            for(int j=i+1 ; j<l ; j++){
                if((long)nums[i]>2*(long)nums[j]){
                    ans++;
                }
            }
        }
        return ans;
    }



    public int reversePairs(int[] nums) {
        int l=nums.length;
        return myMergeSort(nums , 0 , l-1);


    }

    private int myMergeSort(int[] nums , int start , int end){
//        if(start==end){     如果 nums==[] 的话 会无限循环
        if(start>=end){
            return 0;
        }
        int mid=(start+end)/2;
        int ans=myMergeSort(nums , start , mid)+myMergeSort(nums , mid+1 , end);
        int j=mid+1;
        for(int i=start ; i<mid+1 ; i++){
            while (j<end+1 && (long)nums[i]>2*(long)nums[j]){
                j++;
            }
            ans+=j-mid-1;
        }
        Arrays.sort(nums , start , end+1);
        return ans;
    }
}
