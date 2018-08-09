//
//Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
//
//        For example,
//        [2,3,4], the median is 3
//
//        [2,3], the median is (2 + 3) / 2 = 2.5
//
//        Design a data structure that supports the following two operations:
//
//        void addNum(int num) - Add a integer number from the data stream to the data structure.
//        double findMedian() - Return the median of all elements so far.
//        Example:
//
//        addNum(1)
//        addNum(2)
//        findMedian() -> 1.5
//        addNum(3)
//        findMedian() -> 2


import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {

    /** initialize your data structure here. */
    int n=0;
    PriorityQueue<Integer> q=new PriorityQueue<>(10 , (x , y)->x-y);
    PriorityQueue<Integer> p=new PriorityQueue<>(10 , (x , y)->y-x);
    public FindMedianFromDataStream295() {

    }

    public void addNum(int num) {
        q.add(num);
        n++;
        balance();
    }

    public double findMedian() {
        if(n%2==1){
            return (double)q.peek();
        }else{
            return (double)(q.peek()+p.peek())/2;
        }
    }
    private void balance(){
        while(!p.isEmpty() && !q.isEmpty() && p.peek()>q.peek()){
            p.add(q.poll());
        }
        int n=q.size();
        int m=p.size();
        while(n>m+1){
            p.add(q.poll());
            n--;
            m++;
        }
        while(m>n){
            q.add(p.poll());
            n++;
            m--;
        }
    }




//    Runtime Error Message:
//    Exception in thread "main" java.lang.NullPointerException
//    at MedianFinder.findMedian(MedianFinder.java:21)
//    at __Driver__.__helperSelectMethod__(__Driver__.java:17)
//    at __Driver__.__helper__(__Driver__.java:35)
//    at __Driver__.main(__Driver__.java:80)
//    Last executed input:
//            ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//            [[],[1],[2],[],[3],[]]


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
