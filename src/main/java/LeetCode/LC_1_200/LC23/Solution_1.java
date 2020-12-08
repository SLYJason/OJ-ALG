package LeetCode.LC_1_200.LC23;

import Shared.ListNode;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode merged = lists[0];
        for(int i=1; i<lists.length; i++) {
            merged = mergeTwoLists(merged, lists[i]);
        }
        return merged;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
