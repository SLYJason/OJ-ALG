package LeetCode.LC_1_200.LC94;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

/**
 * Solution 1: iterative DFS.
 */
public class Solution_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList();
        List<Integer> res = new ArrayList();
        ArrayDeque<TreeNode> stack = new ArrayDeque();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
