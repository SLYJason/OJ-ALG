package LeetCode.LC_1_200.LC133;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 2: BFS.
 */
public class Solution_2 {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap();
        Queue<Node> queue = new LinkedList();
        map.put(node, new Node(node.val));
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node neighbor : cur.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
