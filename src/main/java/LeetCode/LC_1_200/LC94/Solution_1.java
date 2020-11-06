package LeetCode.LC_1_200.LC94;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: recursive DFS.
 */
public class Solution_1 {
    List<Integer> res = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
