package LeetCode.LC_1_200.LC148;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import Shared.ListNode;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // step 1: sort.
        List<ListNode> list = new ArrayList<>();
        ListNode dummy = new ListNode(), cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        list.sort(Comparator.comparingInt(n -> n.val));

        // step 2: get the result.
        cur = dummy;
        for (ListNode listNode : list) {
            cur.next = listNode;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
