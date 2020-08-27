package LeetCode.LinkedList;

import Shared.ListNode;

import java.util.PriorityQueue;

/**
 * Solution 1: using PriorityQueue, intuitive thoughts but good enough.
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for(ListNode node : lists) {
            while(node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;
        }
        curr.next = null;
        return dummy.next;
    }
}
