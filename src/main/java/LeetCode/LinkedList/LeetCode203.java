package LeetCode.LinkedList;

import Shared.ListNode;

public class LeetCode203 {
    /**
     * Solution 1: iterative
     */
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

    /**
     * Solution 1: recursive
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
