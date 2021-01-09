package LeetCode.LC_1401_1600.LC1506;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: hashset.
 */
public class Solution_1 {
    public Node findRoot(List<Node> tree) {
        Set<Node> set = new HashSet<>();
        for(Node node : tree) {
            for(Node children : node.children) set.add(children);
        }
        for(Node node : tree) {
            if(!set.contains(node)) return node;
        }
        return null;
    }
}
