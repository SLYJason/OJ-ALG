package LeetCode.LC_201_400.LC203;

import Shared.ListNode;

/**
 * Solution 1: recursive.
 */
public class Solution_2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}