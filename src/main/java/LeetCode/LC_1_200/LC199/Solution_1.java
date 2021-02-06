package LeetCode.LC_1_200.LC199;

import Shared.TreeNode;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Solution 1: BFS.
 */
public class Solution_1 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            for(int i=queue.size(); i>0; i--) {
                TreeNode node = queue.poll();
                if(i == 1) res.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
