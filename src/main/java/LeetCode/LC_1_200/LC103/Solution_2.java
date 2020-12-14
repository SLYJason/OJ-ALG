package LeetCode.LC_1_200.LC103;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: DFS.
 */
public class Solution_2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null) return;
        if(res.size() == level) res.add(new ArrayList());
        if(level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    }
}
