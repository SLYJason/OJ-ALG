package LeetCode.LC_1_200.LC141;

import Shared.ListNode;

/**
 * Solution: Floyd's Tortoise and Hare algorithm.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
