package LeetCode.BackTrack;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList();
        Arrays.sort(candidates);
        backTrack(candidates, target, new LinkedList(), res, 0);
        return res;
    }

    private void backTrack(int[] candidates, int remain, List<Integer> list, List<List<Integer>> res, int start) {
        if(remain < 0) return;
        if(remain == 0) {
            res.add(new LinkedList(list));
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            list.add(candidates[i]);
            backTrack(candidates, remain-candidates[i], list, res, i);
            list.remove(list.size()-1);
        }
    }
}
