package LeetCode.LC_1_200.LC61;

import Shared.ListNode;

/**
 * Solution: rotate + link.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        // step 1: get the list length.
        int length = 1;
        ListNode oldEnd = head;
        while (oldEnd.next != null) {
            length++;
            oldEnd = oldEnd.next;
        }

        // step 2: determine the rotate point.
        k = k % length;
        if (k == 0) return head;
        k = length - k; // rotate point.
        ListNode newTail = head;
        while (k > 1) {
            k--;
            newTail = newTail.next;
        }

        // step 3: rotate list.
        ListNode newHead = newTail.next;
        newTail.next = null;
        oldEnd.next = head;
        return newHead;
    }
}
