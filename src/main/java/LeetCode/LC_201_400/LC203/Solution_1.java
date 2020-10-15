package LeetCode.LC_201_400.LC203;

import Shared.ListNode;

/**
 * Solution 1: iterative
 */
public class Solution_1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}