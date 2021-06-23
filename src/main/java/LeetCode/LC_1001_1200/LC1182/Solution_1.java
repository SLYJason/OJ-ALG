package LeetCode.LC_1001_1200.LC1182;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: binary search.
 */
public class Solution_1 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = colors.length;
        // initialization.
        for(int i = 1; i <= 3; i++) map.put(i, new ArrayList());
        for(int i = 0; i < n; i++) {
            map.get(colors[i]).add(i);
        }
        // execute the queries.
        List<Integer> res = new ArrayList<>();
        for(int[] q : queries) {
            res.add(binarySearch(map.get(q[1]), q[0]));
        }
        return res;
    }

    private int binarySearch(List<Integer> list, int start) {
        if(list.isEmpty()) return -1;
        int left = 0, right = list.size() - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) == start) {
                return 0;
            } else if(list.get(mid) < start) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(left == 0) return Math.abs(start - list.get(0));
        return Math.min(Math.abs(start - list.get(left)), Math.abs(start - list.get(left-1)));
    }
}
