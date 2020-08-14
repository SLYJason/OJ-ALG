package LeetCode.BackTrack;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        backtrack(res, new LinkedList(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
        if(tempList.size() == nums.length) {
            res.add(new LinkedList(tempList));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }
}
