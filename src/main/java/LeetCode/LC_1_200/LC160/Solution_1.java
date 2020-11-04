package LeetCode.LC_1_200.LC160;

import Shared.ListNode;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: using HashSet.
 */
public class Solution_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> path = new HashSet();
        ListNode p1 = headA;
        while(p1 != null) {
            path.add(p1);
            p1 = p1.next;
        }
        ListNode p2 = headB;
        while(p2 != null) {
            if(path.contains(p2)) return p2;
            p2 = p2.next;
        }
        return null;
    }
}
