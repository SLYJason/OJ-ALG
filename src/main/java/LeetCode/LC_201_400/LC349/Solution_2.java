package LeetCode.LC_201_400.LC349;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Solution 2: sorting + two-pointers.
 */
public class Solution_2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return set.stream().mapToInt(n -> n).toArray();
    }
}
