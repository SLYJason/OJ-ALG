package LeetCode.LC_601_800.LC632;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] range = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (List<Integer> num : nums) {
            for (int n : num) {
                range[0] = Math.min(range[0], n);
                range[1] = Math.max(range[1], n);
            }
        }
        dfs(0, new ArrayList<>(), nums, range);
        return range;
    }

    private void dfs(int index, List<Integer> list, List<List<Integer>> nums, int[] range) {
        if (list.size() == nums.size()) {
            List<Integer> copy = new ArrayList<>(list);
            Collections.sort(copy);
            int diff = copy.get(copy.size() - 1) - copy.get(0);
            if (diff < range[1] - range[0] || diff == range[1] - range[0] && copy.get(0) < range[0]) {
                range[0] = copy.get(0);
                range[1] = copy.get(copy.size() - 1);
            }
            return;
        }
        List<Integer> num = nums.get(index);
        for (Integer integer : num) {
            list.add(integer);
            dfs(index + 1, list, nums, range);
            list.remove(list.size() - 1);
        }
    }
}
