package LeetCode.LC_1601_1800.LC1675;

import java.util.TreeSet;

/**
 * Solution 2: TreeSet.
 */
public class Solution_2 {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
        // double odd number and push every number into set.
        for(int n : nums) {
            int pushed = n % 2 == 0 ? n : n * 2;
            set.add(pushed);
        }
        int min_dev = set.first() - set.last();
        // decrease the maximum number to find the minimum deviation.
        while(set.first() % 2 == 0) {
            int n = set.pollFirst();
            set.add(n / 2);
            min_dev = Math.min(min_dev, set.first() - set.last()); // check minimum deviation.
        }
        return min_dev;
    }
}
