package LeetCode.Array;

import java.util.Map;
import java.util.HashMap;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}