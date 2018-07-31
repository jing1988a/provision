//Given a collection of intervals, merge all overlapping intervals.
//
//        Example 1:
//
//        Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//        Example 2:
//
//        Input: [[1,4],[4,5]]
//        Output: [[1,5]]
//        Explanation: Intervals [1,4] and [4,5] are considerred overlapping.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals56 {
    public List<Interval> merge(List<Interval> intervals) {
        int l=intervals.size();
        if(l<2){return intervals;}
        List<Interval> ans=new ArrayList<>();
        Collections.sort(intervals ,(x , y )->x.start-y.start);
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1 ; i<l ; i++){
            if(intervals.get(i).start<=end){
                end=Math.max(end , intervals.get(i).end);
            }else{
                ans.add(new Interval(start , end));
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }

        }
        ans.add(new Interval(start , end));
        return ans;
    }
}
