package LeetCode;

import java.util.Queue;
import java.util.LinkedList;

public class LeetCode346 {
    class MovingAverage {
        Queue<Integer> stream;
        int size;
        double sum = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            stream = new LinkedList<Integer>();
            this.size = size;
        }

        public double next(int val) {
            if(stream.size() >= this.size) {
                sum -= stream.remove();
            }
            stream.add(val);
            sum += val;
            return sum / stream.size();
        }
    }
}
