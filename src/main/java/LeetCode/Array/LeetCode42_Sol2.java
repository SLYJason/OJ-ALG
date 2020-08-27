package LeetCode.Array;

/**
 * Solution 2: DP. Hard to think.
 * left_max[i]: maximum height from left to index i.
 * right_max[i]: maximum height from right to index i.
 */
public class LeetCode42_Sol2 {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int area = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = height[0];
        for(int i=1; i<height.length; i++) {
            left_max[i] = Math.max(left_max[i-1], height[i]);
        }
        right_max[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            right_max[i] = Math.max(right_max[i+1], height[i]);
        }
        for(int i=1; i<height.length-1; i++) {
            area += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return area;
    }
}
