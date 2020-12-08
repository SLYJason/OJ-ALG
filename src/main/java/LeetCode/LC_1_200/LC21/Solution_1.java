package LeetCode.LC_1_200.LC21;

import Shared.ListNode;

/**
 * Solution 1: iterative.
 */
public class Solution_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode();
        dummy.next = l1.val < l2.val ? l1 : l2;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                ListNode temp = l1.next;
                l1.next = l2;
                l1 = temp;
                l2 = l2.next;
            } else {
                ListNode temp = l2.next;
                l2.next = l1;
                l2 = temp;
                l1 = l1.next;
            }
        }
        return dummy.next;
    }
}
