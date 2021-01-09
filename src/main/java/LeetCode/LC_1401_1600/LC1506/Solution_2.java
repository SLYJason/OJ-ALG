package LeetCode.LC_1401_1600.LC1506;

import java.util.List;

/**
 * Solution 2: bit manipulation.
 */
public class Solution_2 {
    public Node findRoot(List<Node> tree) {
        int sum = 0;
        for(Node node : tree) {
            sum ^= node.val;
            for(Node children : node.children) sum ^= children.val;
        }
        for(Node node : tree) {
            if(sum == node.val) return node;
        }
        return null;
    }
}
