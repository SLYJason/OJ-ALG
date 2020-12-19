package LeetCode.LC_201_400.LC206;

import Shared.ListNode;

/**
 * Solution: iterative.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
