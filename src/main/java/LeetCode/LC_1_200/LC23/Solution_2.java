package LeetCode.LC_1_200.LC23;

import Shared.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution 2: PriorityQueue.
 */
public class Solution_2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) {
            if (node != null) queue.offer(node); // insert every list node head only.
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (cur.next != null) queue.offer(cur.next);
        }
        return dummy.next;
    }
}
