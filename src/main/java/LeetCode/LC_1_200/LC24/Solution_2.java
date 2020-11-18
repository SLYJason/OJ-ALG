package LeetCode.LC_1_200.LC24;

import Shared.ListNode;

/**
 * Solution 2: recursive.
 */
public class Solution_2 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(head.next.next);
        second.next = first;
        return second;
    }
}
