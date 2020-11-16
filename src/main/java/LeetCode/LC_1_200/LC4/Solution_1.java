package LeetCode.LC_1_200.LC4;

/**
 * Solution 1: two-pointers.
 */
public class Solution_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i=0, j=0, idx = 0;
        while(i < nums1.length && j < nums2.length) {
            merged[idx++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i < nums1.length) merged[idx++] = nums1[i++];
        while(j < nums2.length) merged[idx++] = nums2[j++];
        return merged.length % 2 == 0 ?
                (merged[merged.length/2-1] + merged[merged.length/2]) * 0.5 : (double)merged[merged.length/2];
    }
}
