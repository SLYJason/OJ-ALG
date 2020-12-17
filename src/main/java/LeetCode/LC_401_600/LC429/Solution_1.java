package LeetCode.LC_401_600.LC429;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(Node root, int level, List<List<Integer>> res) {
        if(root == null) return;
        if(res.size() == level) res.add(new ArrayList());
        res.get(level).add(root.val);
        for(Node node : root.children) dfs(node, level+1, res);
    }
}
