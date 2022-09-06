package LeetCode.LC_601_800.LC658;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Solution 2: sort with custom comparator.
 */
public class Solution_2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sorted = new ArrayList<>();
        for (int n : arr) {
            sorted.add(n);
        }
        Collections.sort(sorted, (a, b) -> Math.abs(a - x) - Math.abs(b - x));
        List<Integer> res = sorted.subList(0, k);
        Collections.sort(res);
        return res;
    }
}
