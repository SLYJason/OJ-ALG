package LeetCode.LC_601_800.LC718;

/**
 * Solution 1: Brute Force - Time Limit Exceeded.
 */
public class Solution_1 {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0, n1 = nums1.length, n2 = nums2.length;
        for (int p1 = 0; p1 < n1; p1++) {
            for(int p2 = 0; p2 < n2; p2++) {
                int i = p1;
                for(int j = p2; i < n1 && j < n2; j++) {
                    if(nums1[i++] != nums2[j]) break;
                    max = Math.max(max, i - p1);
                }
            }
        }
        return max;
    }
}
