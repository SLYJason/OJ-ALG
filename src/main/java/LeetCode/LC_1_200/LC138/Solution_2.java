package LeetCode.LC_1_200.LC138;

/**
 * Solution 2: O(1) space.
 */
public class Solution_2 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node p1 = head;
        // step 1: copy each node.
        while (p1 != null) {
            Node copy = new Node(p1.val);
            Node next = p1.next;
            p1.next = copy;
            copy.next = next;
            p1 = next;
        }

        // step 2: link random node.
        p1 = head;
        while (p1 != null) {
            Node copy = p1.next;
            copy.random = p1.random == null ? null : p1.random.next;
            p1 = copy.next;
        }

        // step 3: link next node, recover the original list.
        p1 = head;
        Node p2 = head.next;
        Node copy = head.next; // Important! Since we are modifying the reference.
        while (p2 != null) {
            Node next = p2.next;
            p1.next = next;
            p2.next = next == null ? null : next.next;
            p1 = next;
            p2 = next == null ? null : next.next;
        }
        return copy;
    }
}
