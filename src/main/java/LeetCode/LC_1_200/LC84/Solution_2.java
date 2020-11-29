package LeetCode.LC_1_200.LC84;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Solution 2: monolithic stack.
 */
public class Solution_2 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        Deque<Integer> stack = new ArrayDeque();
        stack.push(-1);
        int i = 0, max_area = 0, n = heights.length;
        while(i < n) {
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                max_area = Math.max(max_area, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i++);
        }
        while(stack.peek() != -1) {
            max_area = Math.max(max_area, heights[stack.pop()] * (n - stack.peek() - 1));
        }
        return max_area;
    }
}
