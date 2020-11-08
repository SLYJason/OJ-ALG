package LeetCode.LC_1_200.LC102;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: Recursive.
 */
public class Solution_1 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        levelOrder(root, 0);
        return res;
    }

    private void levelOrder(TreeNode root, int level) {
        if(root == null) return;
        if(res.size() == level) res.add(new ArrayList());
        res.get(level).add(root.val);
        levelOrder(root.left, level+1);
        levelOrder(root.right, level+1);
    }
}
