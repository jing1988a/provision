//
//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
//        For example,
//        MovingAverage m = new MovingAverage(3);
//        m.next(1) = 1
//        m.next(10) = (1 + 10) / 2
//        m.next(3) = (1 + 10 + 3) / 3
//        m.next(5) = (10 + 3 + 5) / 3

package fb.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MovingAveragefromDataStream346 {
    // List<Integer> window=new LinkedList<>();  list 是没有 addFirst or removeFirst的  意外不意外 惊喜不惊喜？？？
    Deque<Integer> window=new LinkedList<>();
    int size=0;
    double total=0;
    int length=0;
    public MovingAveragefromDataStream346(int size) {
        this.size=size;
    }

    public double next(int val) {
        if(this.size==this.length){
            this.total+=val-this.window.removeFirst();
            this.window.addLast(val);

        }else{
            this.length++;
            this.total+=val;
            this.window.addLast(val);
        }
        return this.total/this.length;
    }
}
