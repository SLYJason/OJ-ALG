package LeetCode.LC_1_200.LC19;

import Shared.ListNode;

/**
 * Solution 2: One Pass.
 */
public class Solution_2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (n > 0) {
            n--;
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
