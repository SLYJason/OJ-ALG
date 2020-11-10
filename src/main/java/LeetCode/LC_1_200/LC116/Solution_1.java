package LeetCode.LC_1_200.LC116;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: BFS.
 */
public class Solution_1 {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node prev = new Node();
            for(int i=queue.size(); i>0; i--) {
                Node node = queue.poll();
                prev.next = node;
                prev = node;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            prev.next = null;
        }
        return root;
    }
}
