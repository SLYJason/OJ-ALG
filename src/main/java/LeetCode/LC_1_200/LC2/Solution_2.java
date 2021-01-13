package LeetCode.LC_1_200.LC2;

import Shared.ListNode;

/**
 * Solution 2: O(1) space.
 */
public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1, pre = null;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            if(l1 != null) {
                l1.val = sum % 10;
                pre = l1;
            } else {
                pre.next = l2;
                pre = l2;
                l2.val = sum % 10;
            }

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry == 1) pre.next = new ListNode(1);
        return head;
    }
}
