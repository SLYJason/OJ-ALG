package LeetCode.LC_401_600.LC581;

import java.util.ArrayDeque;

/**
 * Solution 2: stack.
 */
public class Solution_2 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        // 1st pass find the left boundary.
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        // 2nd pass find the right boundary.
        stack.clear();
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return l == Integer.MAX_VALUE ? 0 : r - l + 1;
    }
}
