package LeetCode.LC_201_400.LC349;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: two sets.
 */
public class Solution_1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1) set1.add(num);
        for(int num : nums2) {
            if(set1.contains(num)) set2.add(num);
        }
        return set2.stream().mapToInt(n -> n).toArray();
    }
}
