package LeetCode.Array;

/**
 * Solution 3: optimal solution.
 * Time Complexity: O(N).
 * Space Complexity: O(1).
 */
public class LeetCode42_Sol3 {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int area = 0;
        // find the max height and corresponding index
        int max_index = Integer.MIN_VALUE, max_height = 0;
        for(int i=0; i<height.length; i++) {
            if(height[i] > max_height) {
                max_height = height[i];
                max_index = i;
            }
        }
        // calculate the left area from max_index
        int left_max_height = height[0];
        for(int i=1; i<max_index; i++) {
            if(height[i] > left_max_height) {
                left_max_height = height[i];
            } else {
                area += left_max_height - height[i];
            }
        }
        // calculate the right area from max_index
        int right_max_height = height[height.length-1];
        for(int i=height.length-2; i>max_index; i--) {
            if(height[i] > right_max_height) {
                right_max_height = height[i];
            } else {
                area += right_max_height - height[i];
            }
        }
        return area;
    }
}
