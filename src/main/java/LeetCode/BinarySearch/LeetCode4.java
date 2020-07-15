package LeetCode.BinarySearch;

public class LeetCode4 {
    /** Time Complexity: O(log(min(m, n))).
     *           L1  R1
     * nums1: 3  5 | 8  9
     * nums2: 1  2  7 | 10  11  12
     *              L2  R2
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int len = nums1.length + nums2.length;
        // cut1是nums1左边切割的元素个数，cut2是nums2左边切割的元素个数
        int cut1 = 0, cut2 = 0;
        int left = 0, right = nums1.length;
        while(cut1 <= nums1.length) {
            cut1 = left + (right - left)/2;
            cut2 = len/2 - cut1;
            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            if(L1 > R2) {
                right = cut1 - 1;
            } else if (L2 > R1) {
                left = cut1 + 1;
            } else {
                if(len % 2 == 0) {
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 > R2 ? R2 : R1;
                    return (L1 + R1)/2;
                } else {
                    return R1 > R2 ? R2 : R1;
                }
            }
        }
        return -1;
    }
}
