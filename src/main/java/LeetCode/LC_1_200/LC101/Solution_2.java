package LeetCode.LC_1_200.LC101;

import Shared.TreeNode;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 2: iterative.
 * Keep in mind: LinkedList allows null, but ArrayDeque not.
 */
public class Solution_2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()) {
            TreeNode rootA = queue.poll();
            TreeNode rootB = queue.poll();
            if(rootA == null && rootB == null) continue;
            if(rootA == null || rootB == null) return false;
            if(rootA.val != rootB.val) return false;
            queue.offer(rootA.left);
            queue.offer(rootB.right);
            queue.offer(rootA.right);
            queue.offer(rootB.left);
        }
        return true;
    }
}
