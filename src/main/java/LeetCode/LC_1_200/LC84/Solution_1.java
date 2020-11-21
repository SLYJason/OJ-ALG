package LeetCode.LC_1_200.LC84;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int largestRectangleArea(int[] heights) {
        int max_area = 0;
        for(int i=0; i<heights.length; i++) {
            int min_height = heights[i];
            for(int j=i; j<heights.length; j++) {
                min_height = Math.min(min_height, heights[j]);
                max_area = Math.max(max_area, min_height * (j-i+1));
            }
        }
        return max_area;
    }
}
