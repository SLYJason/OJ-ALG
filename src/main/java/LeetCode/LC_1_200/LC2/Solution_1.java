package LeetCode.LC_1_200.LC2;

import Shared.ListNode;

/**
 * Solution 1: O(N) space.
 */
public class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(p1 != null || p2 != null) {
            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;

            cur.next = new ListNode();
            cur = cur.next;
            cur.val = sum % 10;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
