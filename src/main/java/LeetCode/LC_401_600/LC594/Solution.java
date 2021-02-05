package LeetCode.LC_401_600.LC594;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution: HashMap.
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            int min = n - 1, max = n + 1;
            if(map.containsKey(min)) res = Math.max(res, map.get(n) + map.get(min));
            if(map.containsKey(max)) res = Math.max(res, map.get(n) + map.get(max));
        }
        return res;
    }
}
