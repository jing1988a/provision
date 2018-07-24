//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
//
//        Example 1:
//
//        Input: [[0,30],[5,10],[15,20]]
//        Output: false
//        Example 2:
//
//        Input: [[7,10],[2,4]]
//        Output: true


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        int l=intervals.length;
        if(l==0) {
            return true;
        }
        Arrays.sort(intervals , (i1 , i2)->i1.start-i2.start);
        int curEnd=intervals[0].end;
        int i=1;
        while(i<l){
            if(curEnd>intervals[i].start){
                return false;
            }
            curEnd=intervals[i].end;
            i++;
        }
//        Arrays.sort(intervals , Comparator.comparing(Interval::start));
//        System.out.println(intervals);
        return true;


    }


    static public void main(String[] args) {
        Interval[] intervals=new Interval[3];
        intervals[0]=new Interval(20 , 10);
        intervals[1]=new Interval(5 , 10);
        intervals[2]=new Interval(1 , 2);
        MeetingRooms252 test=new MeetingRooms252();
        test.canAttendMeetings(intervals);
//        System.out.println("what");

    }
}
