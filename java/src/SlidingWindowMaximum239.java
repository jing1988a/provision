//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
//
//        Example:
//
//        Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//        Output: [3,3,5,5,6,7]
//        Explanation:
//
//        Window position                Max
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
//
//        Follow up:
//        Could you solve it in linear time?


import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new LinkedList();
        int l=nums.length;
        if(l==0){return new int[] {};}
        int[] ans=new int[l-k+1];
        for(int i=0 ; i<nums.length; i++){
            if(!q.isEmpty() && i-k==q.peekFirst()){
                q.poll();
            }
            while(!q.isEmpty() &&nums[i]>=nums[q.peekLast()]){
                //q.pop();//这个会当做q popFirst  q.remove 也会相当于 removeFirst
                q.removeLast();
            }

            q.add(i);

            if(i-k+1>=0){
                ans[i-k+1]=nums[q.peekFirst()];
            }
        }
        return ans;
    }

    static public void main(String[] args){
        SlidingWindowMaximum239 test=new SlidingWindowMaximum239();
        test.maxSlidingWindow(new int[] {1,3,1,2,0,5 } , 3 );
    }
}
