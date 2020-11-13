package LeetCode.LC_201_400.LC234;

import Shared.ListNode;

/**
 * Solution: O(1) space complexity.
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        int len = 0;
        ListNode p1 = head;
        // Step 1: find list length.
        while(p1 != null) {
            len++;
            p1 = p1.next;
        }
        // Step 2: reverse the latter half of the list.
        len /= 2;
        ListNode p2 = head;
        while(len-- > 0) p2 = p2.next;
        ListNode cur = p2.next;
        p2.next = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = p2;
            p2 = cur;
            cur = next;
        }
        // Step 3: compare p1 and p2.
        p1 = head;
        while(p1 != null && p2 != null) {
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
