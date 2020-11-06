package LeetCode.LC_1_200.LC144;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

/**
 * Solution 2: iterative DFS.
 */
public class Solution_2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList();
        List<Integer> res = new ArrayList();
        ArrayDeque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
    }
}
