package LeetCode.LC_401_600.LC430;

import java.util.ArrayDeque;

public class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node dummy = new Node();
        dummy.next = head;
        Node prev = dummy;

        ArrayDeque<Node> stack = new ArrayDeque();
        stack.push(head);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            prev.next = cur;
            cur.prev = prev;
            if(cur.next != null) stack.push(cur.next);
            if(cur.child != null) {
                stack.push(cur.child);
                cur.child = null; // need to set child to null.
            }
            prev = cur;
        }
        head.prev = null; // remove the reference to the dummy node.
        return head;
    }
}
