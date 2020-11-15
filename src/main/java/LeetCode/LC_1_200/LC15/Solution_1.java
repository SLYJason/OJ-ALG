package LeetCode.LC_1_200.LC15;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: two-sum logic.
 */
public class Solution_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        for(int i=0; i<nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue; // skip same results.
            // Two-Sum logic.
            int sum = -nums[i];
            Map<Integer, Integer> map = new HashMap(); // K: num, V: count of num.
            for(int j=i+1; j<nums.length; j++) {
                if(map.containsKey(nums[j])) {
                    if(map.get(nums[j]) == 1) {
                        res.add(Arrays.asList(nums[i], sum - nums[j], nums[j]));
                    }
                    map.put(nums[j], map.get(nums[j])+1);
                } else {
                    map.put(sum - nums[j], 1);
                }
            }
        }
        return res;
    }
}
