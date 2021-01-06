package LeetCode.LC_1001_1200.LC1060;

/**
 * Solution 2: binary search.
 */
public class Solution_2 {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int missing = nums[nums.length-1] - nums[0] + 1 - n;
        if(k > missing) return nums[nums.length-1] + k - missing; // base case.

        int left = 0, right = nums.length-1;
        while(left < right - 1) { // binary search will stop when left and right are neighbors.
            int mid = left + (right - left) / 2;
            missing = nums[mid] - nums[left] + 1 - (mid - left + 1);
            if(missing < k) {
                left = mid;
                k -= missing;
            } else {
                right = mid;
            }
        }
        return nums[left] + k;
    }
}
