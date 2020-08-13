package LeetCode.BackTrack;

import java.util.List;
import java.util.LinkedList;

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        backtrack(res, new LinkedList(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            res.add(new LinkedList(tempList));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!tempList.contains(nums[i])) {
                tempList.add(nums[i]);
                backtrack(res, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
