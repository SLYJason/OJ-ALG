package LeetCode.LC_1_200.LC138;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution: using HashMap.
 * Time Complexity: O(N).
 * Space Complexity: O(1).
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> map = new HashMap(); // K: old Node, V: newly created Node.
        // first pass, created new copy of each node.
        Node oldNode = head;
        while(oldNode != null) {
            map.put(oldNode, new Node(oldNode.val));
            oldNode = oldNode.next;
        }
        // second pass, link each newly created node.
        oldNode = head;
        while(oldNode != null) {
            Node newNode = map.get(oldNode);
            newNode.next = map.get(oldNode.next);
            newNode.random = map.get(oldNode.random);
            oldNode = oldNode.next;
        }
        return map.get(head);
    }
}
