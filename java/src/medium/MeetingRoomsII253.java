package medium;//
//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//        Example 1:
//
//        Input: [[0, 30],[5, 10],[15, 20]]
//        Output: 2
//        Example 2:
//
//        Input: [[7,10],[2,4]]
//        Output: 1
//


import easy.Interval;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class MeetingRoomsII253 {
    public int minMeetingRooms(Interval[] intervals) {
        HashMap<Integer , Integer> timeDict=new HashMap<>();
        for(Interval interval :intervals){
            if(timeDict.containsKey(interval.start)){
                timeDict.put(interval.start , timeDict.get(interval.start)+1);
            }else{
                timeDict.put(interval.start , 1);
            }

            if(timeDict.containsKey(interval.end)){
                timeDict.put(interval.end , timeDict.get(interval.end)-1);
            }else{
                timeDict.put(interval.end , -1);
            }
        }
        Set<Integer> keys=timeDict.keySet();
        Integer[] times=keys.toArray(new Integer[keys.size()]);
        Arrays.sort(times);
        int ans=0;
        int cur=0;
        for(int t: times){
            cur+=timeDict.get(t);
            ans=Math.max(ans , cur);
        }
        return ans;
    }

}
