package LeetCode.Array;

/**
 * Solution 1: brute force.
 * Time Complexity: O(N^2).
 * Space Complexity: O(1).
 */
public class LeetCode42_Sol1 {
    public int trap(int[] height) {
        int area = 0;
        for(int i=1; i<height.length-1; i++) {
            int maxLeftHeight = 0, maxRightHeight = 0;
            for(int left = i-1; left >= 0; left--) {
                maxLeftHeight = Math.max(maxLeftHeight, height[left]);
            }
            for(int right = i+1; right<height.length; right++) {
                maxRightHeight = Math.max(maxRightHeight, height[right]);
            }
            if(Math.min(maxLeftHeight, maxRightHeight) > height[i]) {
                area += Math.min(maxLeftHeight, maxRightHeight) - height[i];
            }
        }
        return area;
    }
}
