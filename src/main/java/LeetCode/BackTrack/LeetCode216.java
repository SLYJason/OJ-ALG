package LeetCode.BackTrack;

import java.util.List;
import java.util.LinkedList;

public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList();
        backtrack(n, k, 1, new LinkedList(), res);
        return res;
    }

    private void backtrack(int remain, int k, int start, List<Integer> list, List<List<Integer>> res) {
        if(remain < 0 || list.size() > k) return;
        if(remain == 0 && list.size() == k) {
            res.add(new LinkedList(list));
            return;
        }
        for(int i=start; i<=9; i++) {
            list.add(i);
            backtrack(remain - i,k, i+1, list, res);
            list.remove(list.size()-1);
        }
    }
}
