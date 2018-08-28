package fb.medium;
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//        You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//        You may assume no duplicate exists in the array.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        Example 1:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
//        Example 2:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1

public class SearchRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int l=nums.length;
        int start=0;
        int end=l-1;
        while(start<=end){
            int mid=(start+end);
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>nums[end]){
                if(target<nums[mid]&&target>=nums[start]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(nums[mid]<target &&target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;

    }
}
