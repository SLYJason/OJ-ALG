package LeetCode.Tree;

import java.util.Stack;
import Shared.TreeNode;

public class LeetCode230_Sol2 {
    // Solution 2: iterative
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}
