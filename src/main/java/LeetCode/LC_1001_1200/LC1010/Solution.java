package LeetCode.LC_1001_1200.LC1010;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution: two sum.
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int t = time[i] % 60;
            int another = t == 0 ? 0 : 60 - t;
            if (map.containsKey(another)) {
                res += map.get(another);
            }
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return res;
    }
}