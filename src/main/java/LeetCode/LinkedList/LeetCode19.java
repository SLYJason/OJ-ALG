package LeetCode.LinkedList;

import Shared.ListNode;

public class LeetCode19 {
    /**
     * Solution: one-pass
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while(n-- > -1) first = first.next;
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
