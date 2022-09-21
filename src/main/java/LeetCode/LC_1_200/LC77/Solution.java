package LeetCode.LC_1_200.LC77;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Solution: backtracking.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(1, n, k, new LinkedList<>(), res);
        return res;
    }

    public void dfs(int cur, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i <= n; i++) {
            list.add(i);
            dfs(i + 1, n, k, list, res);
            list.remove(list.size() - 1);
        }
    }
}
