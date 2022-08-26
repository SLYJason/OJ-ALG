package LeetCode.LC_1_200.LC19;

import Shared.ListNode;

/**
 * Solution 1: Two Pass.
 */
public class Solution_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // init
        int length = 0;
        ListNode dummy = new ListNode(), cur = head;
        dummy.next = head;
        // 1st pass
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        // 2nd pass
        int target = length - n;
        cur = dummy;
        while (target > 0) {
            target--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
