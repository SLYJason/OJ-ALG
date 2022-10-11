package LeetCode.LC_1001_1200.LC1094;

import java.util.TreeMap;

/**
 * Solution 2: TreeMap.
 */
public class Solution_2 {
    public boolean carPooling(int[][] trips, int capacity) {
        if (capacity < 1) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            int passengers = trip[0], start = trip[1], end = trip[2];
            map.put(start, map.getOrDefault(start, 0) + passengers);
            map.put(end, map.getOrDefault(end, 0) - passengers);
        }

        int totalPassengers = 0;
        for (int passenger : map.values()) {
            totalPassengers += passenger;
            if (totalPassengers > capacity) return false;
        }
        return true;
    }
}
