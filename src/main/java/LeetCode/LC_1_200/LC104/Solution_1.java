package LeetCode.LC_1_200.LC104;

import Shared.TreeNode;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: BFS.
 */
public class Solution_1 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int max_depth = 0;
        while(!queue.isEmpty()) {
            max_depth++;
            for(int i=queue.size(); i>0; i--) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return max_depth;
    }
}
