package LeetCode.LC_401_600.LC429;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution 2: BFS.
 */
public class Solution_2 {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList();
        List<List<Integer>> res = new ArrayList();
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            for(int i=queue.size(); i>0; i--) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
}
