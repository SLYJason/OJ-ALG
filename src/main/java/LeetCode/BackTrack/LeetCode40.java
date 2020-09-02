package LeetCode.BackTrack;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList();
        backtrack(candidates, target, new LinkedList(), 0, res);
        return res;
    }

    private void backtrack(int[] candidates, int remain, List<Integer> list, int start, List<List<Integer>> res) {
        if(remain < 0) return;
        if(remain == 0) {
            res.add(new LinkedList(list));
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            backtrack(candidates, remain-candidates[i], list, i+1, res);
            list.remove(list.size()-1);
        }
    }
}
