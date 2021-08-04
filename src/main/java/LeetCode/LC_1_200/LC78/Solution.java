package LeetCode.LC_1_200.LC78;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        if(start == nums.length) return;
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(i + 1, nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}
