package hard;//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
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


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        Stack<List<Integer>> stack=new Stack<>();
        List<Integer> temp0=new ArrayList<>();
        temp0.add(heights[0]);
        temp0.add(0);
        stack.push(temp0);
        int l=heights.length;
        int ans=0;
        for(int i=1 ; i<l ; i++){
            int curIdx=i;
            while(!stack.isEmpty() && stack.peek().get(0)>heights[i]){
                List<Integer> cur=stack.pop();
                ans=Math.max(ans , (i-cur.get(1))*cur.get(0));
                curIdx=cur.get(1);
            }
            if(stack.isEmpty() || stack.peek().get(0)<heights[i]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(heights[i]);
                temp.add(curIdx);
                stack.push(temp);
            }

        }
        while(!stack.isEmpty()){
            List<Integer> left=stack.pop();

            ans=Math.max(ans , left.get(0)*(l-left.get(1)));
        }
        return ans;
    }

    static public void main(String[] args){
        LargestRectangleHistogram84 test=new LargestRectangleHistogram84();
        int[] h={4,2,0,3,2,5};
        int ans=test.largestRectangleArea(h);
        System.out.println(ans);
    }


}
