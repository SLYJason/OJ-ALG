package LeetCode.LC_601_800.LC718;

/**
 * Solution 3: sliding window.
 */
public class Solution_3 {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0, n1 = nums1.length, n2 = nums2.length;
        // fixed nums1, compare nums2 with every nums1 element.
        for (int i = 0; i < n1; i++) {
            int length = findLargestCommon(nums1, nums2, i, 0, Math.min(n1 - i, n2));
            max = Math.max(max, length);
        }
        // fixed nums2, compare nums1 with every nums2 element.
        for (int i = 0; i < n2; i++) {
            int length = findLargestCommon(nums1, nums2, 0, i, Math.min(n1, n2 - i));
            max = Math.max(max, length);
        }
        return max;
    }

    private int findLargestCommon(int[] nums1, int[] nums2, int start1, int start2, int len) {
        int max = 0, common = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[start1 + i] == nums2[start2 + i]) {
                common++;
                max = Math.max(max, common);
            } else {
                common = 0;
            }
        }
        return max;
    }
}
