package LeetCode.LC_401_600.LC414;

import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * Solution 2: using Set.
 */
public class Solution_2 {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        Set<Integer> set = new HashSet();
        for(int num : nums) {
            set.add(num);
            if(set.size() > 3) {
                set.remove(Collections.min(set));
            }
        }
        return set.size() == 3 ? Collections.min(set) : Collections.max(set);
    }
}
