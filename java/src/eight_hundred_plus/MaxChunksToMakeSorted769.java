package eight_hundred_plus;
//Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
//
//        What is the most number of chunks we could have made?
//
//        Example 1:
//
//        Input: arr = [4,3,2,1,0]
//                     [0 0 0 0 inf]
//                     [4 4 4 4 4]
//        Output: 1
//        Explanation:
//        Splitting into two or more chunks will not return the required result.
//        For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
//        Example 2:
//
//        Input: arr = [1,0,1,3,4]
//                     [0 1 3 4 inf]
//                     [1 1 2 3 4]
//        Output: 4
//        Explanation:
//        We can split into two chunks, such as [1, 0], [2, 3, 4].
//        However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
//        Note:
//
//        arr will have length in range [1, 10].
//        arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
public class MaxChunksToMakeSorted769 {
    public int maxChunksToSorted(int[] arr) {
        int l=arr.length;
        int[] rightMin=new int[l];
        int[] leftMax=new int[l];
        int curMax=Integer.MIN_VALUE;
        for(int i=0 ;  i<l ; i++){
            curMax=Math.max(arr[i] , curMax);
            leftMax[i]=curMax;
        }
        int curMin=Integer.MAX_VALUE;
        for(int i=l-1 ;  i>0 ; i--){
            rightMin[i]=curMin;
            curMin=Math.min(arr[i] , curMin);
        }
        int ans=0;
        for(int i=0 ; i<l ; i++){
            if(rightMin[i]>=leftMax[i]){
                ans+=1;
            }
        }
        return ans;

    }
}
