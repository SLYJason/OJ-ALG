package LeetCode.LC_1_200.LC138;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: HashMap.
 */
public class Solution_1 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node dummy = new Node(-1);
        Node p1 = head;
        Node p2 = dummy;
        Map<Node, Node> map = new HashMap<>(); // K: original node, V: copied node.

        // step 1: copy each node.
        while (p1 != null) {
            Node copy = new Node(p1.val);
            p2.next = copy;
            p2 = copy;
            map.put(p1, p2);
            p1 = p1.next;
        }

        // step 2: link random node.
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node ori = entry.getKey();
            Node copy = entry.getValue();
            copy.random = map.get(ori.random);
        }
        return dummy.next;
    }
}
