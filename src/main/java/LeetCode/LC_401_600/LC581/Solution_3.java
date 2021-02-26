package LeetCode.LC_401_600.LC581;

/**
 * Solution 3: optimal solution.
 */
public class Solution_3 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        // left -> right: find the right boundary.
        int r = 0, max = nums[0];
        for(int i=1; i<n; i++) {
            if(nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }
        }
        // right -> left: find the left boundary.
        int l = n - 1, min = nums[n-1];
        for(int i=n-1; i>=0; i--) {
            if(nums[i] > min) {
                l = i;
            } else {
                min = nums[i];
            }
        }
        return r > l ? r - l + 1 : 0;
    }
}
