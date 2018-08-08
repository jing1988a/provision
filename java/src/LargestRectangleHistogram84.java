//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//        Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//
//
//        The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
//        Example:
//
//        Input: [2,1,5,6,2,3]
//        Output: 10


public class LargestRectangleHistogram84 {
//    public int largestRectangleArea(int[] heights) {
//        int l=heights.length;
//        int ans=0;
//        for(int i=0 ; i<l ; i++){
//            int start=i;
//            int end=i;
//            while(start-1>=0 && heights[start-1]>=heights[i]){
//                start--;
//            }
//            while(end+1<l && heights[end+1]>=heights[i]){
//                end++;
//            }
//            ans=Math.max(ans , (end-start+1)*heights[i]  );
//        }
//        return ans;
//    }
//    [4,2,0,3,2,4,3,4]

    // above is O(n^2)

    public int largestRectangleArea(int[] heights) {
        
    }


}
