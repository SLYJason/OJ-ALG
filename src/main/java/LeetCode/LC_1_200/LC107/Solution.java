package LeetCode.LC_1_200.LC107;

import Shared.TreeNode;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList();
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            for(int i=queue.size(); i>0; i--) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(0, level); // reverse.
        }
        return res;
    }
}
