package LeetCode.LC_1_200.LC145;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: recursive DFS.
 */
public class Solution_1 {
    List<Integer> res = new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
