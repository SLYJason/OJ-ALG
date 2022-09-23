package LeetCode.LC_401_600.LC496;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>(); // key: nums2[i], value: nums2[i] index.
        for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
        for (int i = 0; i < nums1.length; i++) {
            int element = -1;
            for (int j = map.get(nums1[i]); j < nums2.length && element == -1; j++) {
                if (nums2[j] > nums1[i]) {
                    element = nums2[j];
                }
            }
            res[i] = element;
        }
        return res;
    }
}
