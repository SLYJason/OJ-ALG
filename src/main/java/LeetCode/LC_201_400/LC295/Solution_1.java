package LeetCode.LC_201_400.LC295;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: optimized brute force, binary search insertion.
 */
public class Solution_1 {
    class MedianFinder {
        List<Integer> list;
        /** initialize your data structure here. */
        public MedianFinder() {
            list = new ArrayList();
        }

        public void addNum(int num) {
            if(list.isEmpty()) {
                list.add(num);
                return;
            }
            // binary search to find which position should be added.
            int left = 0, right = list.size()-1;
            while(left <= right) {
                int mid = left + (right-left)/2;
                if(list.get(mid) == num) {
                    left = mid;
                    break;
                } else if(list.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            list.add(left, num);
        }

        public double findMedian() {
            if(list.size() % 2 == 0) {
                double median = (double)((list.get(list.size()/2-1) + list.get(list.size()/2))) / 2;
                return median;
            }
            return (double)list.get(list.size() / 2);
        }
    }
}
