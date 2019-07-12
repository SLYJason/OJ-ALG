package LeetCode;

import java.util.Arrays;

public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // nums1 pointer
        int p2 = n - 1; // nums2 pointer
        int p = m + n -1; // global pointer

        while (p2 > -1 && p1 > -1) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }

        // nums1 all placed in right place, but num2 still not
        while (p2 > -1) nums1[p--] = nums2[p2--];
    }

    // Not a good one
    public void mergeSol2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
