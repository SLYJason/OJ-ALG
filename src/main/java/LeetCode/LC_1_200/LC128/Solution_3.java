package LeetCode.LC_1_200.LC128;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 3: Using HashSet.
 */
public class Solution_3 {
    public int longestConsecutive(int[] nums) {
        int l = nums.length;
        if(l <= 1) return l;
        int res = 1;
        Set<Integer> set = new HashSet();
        for(int num : nums) set.add(num);
        for(int num : nums) {
            int length = 1;
            while(set.contains(++num)) {
                length++;
            }
            res = Math.max(res, length);
        }
        return res;
    }
}
