package LeetCode.LinkedList;

import Shared.ListNode;

public class LeetCode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}