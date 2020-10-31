package LeetCode.LC_401_600.LC445;

import Shared.ListNode;

/**
 * Solution 1: brute force, reverse the list first, then add them, using LC2 logic.
 */
public class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        // use LC2 logic here.
        int carry = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode head = null;
        while(p1 != null || p2 != null) {
            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;

            ListNode cur = new ListNode(sum % 10);
            cur.next = head;
            head = cur;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if(carry == 1) {
            ListNode cur = new ListNode(1);
            cur.next = head;
            head = cur;
        }
        return head;
    }

    // reverse the ListNode, less significant digit comes first.
    private ListNode reverse(ListNode l) {
        ListNode prev = null;
        while(l != null) {
            ListNode next = l.next;
            l.next = prev;
            prev = l;
            l = next;
        }
        return prev;
    }
}
