package LeetCode.LC_1_200.LC128;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution 2: HashMap.
 * Time Complexity: O(N).
 * Space Complexity: O(N).
 */
public class Solution_2 {
    public int longestConsecutive(int[] nums) {
        int l = nums.length;
        if(l <= 1) return l;
        int res = 0;
        // K: num[i]; V: length of longest consecutive sequence starting at nums[i] or ending at nums[i], nums[i] can be left or right boundary.
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                int left = map.containsKey(n-1) ? map.get(n-1) : 0;
                int right = map.containsKey(n+1) ? map.get(n+1) : 0;
                int length = left + right + 1;
                map.put(n, length);
                // update the left and right boundary.
                map.put(n-left, length);
                map.put(n+right, length);
                // update the global max length
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
