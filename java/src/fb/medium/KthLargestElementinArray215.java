package fb.medium;
//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//        Example 1:
//
//        Input: [3,2,1,5,6,4] and k = 2
//        Output: 5
//        Example 2:
//
//        Input: [3,2,3,1,2,4,5,5,6] and k = 4
//        Output: 4
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ array's length.

import java.util.PriorityQueue;

public class KthLargestElementinArray215 {
    public int findKthLargest(int[] nums, int k) {
        int l=nums.length;
        if(k>l){
            return -1;
        }
        PriorityQueue<Integer> q=new PriorityQueue<>((x , y)->y-x);
        for(int n : nums){
            q.offer(n);
        }
        int ans=0;
        for(int i=0 ;i<k;i++){
            ans=q.poll();
        }
        return ans;
    }
}
