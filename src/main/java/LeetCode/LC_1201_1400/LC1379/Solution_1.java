package LeetCode.LC_1201_1400.LC1379;

import Shared.TreeNode;
import java.util.ArrayDeque;

/**
 * Solution 1: iterative.
 */
public class Solution_1 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        ArrayDeque<TreeNode> stackA = new ArrayDeque<>();
        ArrayDeque<TreeNode> stackB = new ArrayDeque<>();
        stackA.push(original);
        stackB.push(cloned);
        while(!stackA.isEmpty()) {
            TreeNode rootA = stackA.pop();
            TreeNode rootB = stackB.pop();
            if(rootA == target) return rootB;
            if(rootA.right != null) stackA.push(rootA.right);
            if(rootA.left != null) stackA.push(rootA.left);
            if(rootB.right != null) stackB.push(rootB.right);
            if(rootB.left != null) stackB.push(rootB.left);
        }
        return null;
    }
}
