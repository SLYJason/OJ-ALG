package LeetCode.LC_1_200.LC83;

import Shared.ListNode;

/**
 * Solution 2: recursive.
 */
public class Solution_2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = deleteDuplicates(next);
        return head.val == next.val ? next : head;
    }
}
