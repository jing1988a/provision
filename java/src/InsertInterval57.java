//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//        You may assume that the intervals were initially sorted according to their start times.
//
//        Example 1:
//
//        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        Output: [[1,5],[6,9]]
//        Example 2:
//
//        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        Output: [[1,2],[3,10],[12,16]]
//        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//        Seen this question in a real interview before?
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        intervals.sort((x , y)->x.start-y.start);
        List<Interval> ans=new ArrayList<>();
        int curStart=intervals.get(0).start;
        int curEnd=intervals.get(0).end;
        int i=1;
        while(i<intervals.size()){
            if(intervals.get(i).start>curEnd){
                ans.add(new Interval(curStart , curEnd));
                curStart=intervals.get(i).start;
                curEnd=intervals.get(i).end;
            }else{
                curEnd=Math.max(curEnd , intervals.get(i).end);
            }
            i++;
        }
        ans.add(new Interval(curStart , curEnd));
        return ans;
    }
//    Input:
//            [[1,2],[3,5],[6,7],[8,10],[12,16]]
//            [4,8]
//    Output:
//            [[1,2],[3,5],[6,7],[8,10],[12,16]]
//    Expected:
//            [[1,2],[3,10],[12,16]]


    public class Interval {
        public int start;
        public int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
