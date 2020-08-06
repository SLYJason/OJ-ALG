package LeetCode.Array;

import java.util.Map;
import java.util.HashMap;

public class LeetCode1512 {
    public int numIdenticalPairs(int[] nums) {
        int pair = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums) {
            pair += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return pair;
    }
}
