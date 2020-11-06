package LeetCode.LC_1_200.LC144;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: recursive DFS.
 */
public class Solution_1 {
    List<Integer> res = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
