package LeetCode.LC_1_200.LC41;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int n = nums.length;
        Set<Integer> set = new HashSet();
        for(int num : nums) set.add(num);
        for(int i=1; i<=n; i++) {
            if(!set.contains(i)) return i;
        }
        return n+1;
    }
}
