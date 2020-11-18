package LeetCode.LC_1_200.LC24;

import Shared.ListNode;

/**
 * Solution 1: iterative.
 */
public class Solution_1 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while(cur != null && cur.next != null) {
            ListNode first = cur;
            ListNode second = cur.next;
            // swap nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;
            // move prev and cur.
            prev = first;
            cur = first.next;
        }
        return dummy.next;
    }
}
