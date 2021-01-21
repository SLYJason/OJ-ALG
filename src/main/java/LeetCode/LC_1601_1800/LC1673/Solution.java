package LeetCode.LC_1601_1800.LC1673;

import java.util.ArrayDeque;

/**
 * Solution: Stack.
 */
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[k];
        for(int i=0; i<n; i++) {
            // n - 1 - i: available elements can be pushed.
            // k - stack.size(): rest elements need to be pushed.
            while(!stack.isEmpty() && stack.peek() > nums[i] && n - 1 - i >= k - stack.size()) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        for(int i=k-1; i>=0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}