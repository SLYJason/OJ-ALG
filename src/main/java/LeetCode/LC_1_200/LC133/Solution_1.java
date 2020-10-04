package LeetCode.LC_1_200.LC133;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap());
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node copy = new Node(node.val);
        map.put(node, copy);
        for(Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }
        return copy;
    }
}




