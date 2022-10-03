package LeetCode.LC_2201_2400.LC2215;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution: two sets.
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        // step 1: initialize the set.
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) set1.add(n);
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) set2.add(n);

        // step 2: filter the diff.
        List<Integer> unique1 = new ArrayList<>();
        List<Integer> unique2 = new ArrayList<>();
        for (int n : set2) {
            if (set1.contains(n)) {
                set1.remove(n);
            } else {
                unique2.add(n);
            }
        }

        // step 3: build the final result
        for (int n : set1) unique1.add(n);
        res.add(unique1);
        res.add(unique2);
        return res;
    }
}

