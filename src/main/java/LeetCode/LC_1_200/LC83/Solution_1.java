package LeetCode.LC_1_200.LC83;

import Shared.ListNode;

/**
 * Solution 1: iterative.
 */
public class Solution_1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            if(cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = next;
            }
        }
        return head;
    }
}
