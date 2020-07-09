package LeetCode.Tree;

import Shared.TreeNode;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Solution 1: BFS
 */
public class LeetCode662_Sol1 {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList();
        int maxWidth = 0;
        queue.offer(new AbstractMap.SimpleEntry<>(root, 0));
        while(!queue.isEmpty()) {
            int left = queue.peek().getValue(), right = left;
            int currWidth = queue.size();
            for(int i=0; i<currWidth; i++) {
                Map.Entry<TreeNode, Integer> curr = queue.poll();
                TreeNode node = curr.getKey();
                right = curr.getValue();
                if(node.left != null) {
                    queue.offer(new AbstractMap.SimpleEntry<>(node.left, right*2));
                }
                if(node.right != null) {
                    queue.offer(new AbstractMap.SimpleEntry<>(node.right, right*2+1));
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }
}
