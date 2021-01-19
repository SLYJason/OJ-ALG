package LeetCode.LC_1601_1800.LC1679;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: hashmap.
 */
public class Solution_1 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num : nums) {
            if(map.containsKey(num)) {
                count++;
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) map.remove(num);
            } else {
                map.put(k - num, map.getOrDefault(k - num, 0) + 1);
            }
        }
        return count;
    }
}
