package LeetCode.LC_201_400.LC398;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    class Solution {
        Map<Integer, List<Integer>> map;
        public Solution(int[] nums) {
            map = new HashMap();
            for(int i=0; i<nums.length; i++) {
                if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(new Random().nextInt(list.size()));
        }
    }
}
