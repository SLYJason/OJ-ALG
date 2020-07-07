package LeetCode.LinkedList;

import Shared.ListNode;

public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode interSection = getIntersection(head);
        if(interSection == null) return null;
        ListNode node = head;
        while(node != interSection) {
            node = node.next;
            interSection = interSection.next;
        }
        return node;
    }

    private ListNode getIntersection(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return slow;
        }
        return null;
    }
}
