package LeetCode.LC_1_200.LC103;

import Shared.TreeNode;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Solution: BFS.
 */
public class Solution_1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = true;
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for(int i=queue.size(); i>0; i--) {
                TreeNode node = queue.poll();
                if(zigzag) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            zigzag = !zigzag;
            res.add(level);
        }
        return res;
    }
}
