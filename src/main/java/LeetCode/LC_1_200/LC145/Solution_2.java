package LeetCode.LC_1_200.LC145;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

/**
 * Solution 2: iterative DFS.
 */
public class Solution_2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList();
        List<Integer> res = new ArrayList();
        ArrayDeque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return res;
    }
}
