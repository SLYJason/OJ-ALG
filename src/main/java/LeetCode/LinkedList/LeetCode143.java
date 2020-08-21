package LeetCode.LinkedList;

import Shared.ListNode;
import java.util.ArrayDeque;

public class LeetCode143 {
    /**
     * Solution 1: using stack
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // push the second half of ListNode into stack
        // e.g. 1->4->2->3 push 2->3 to the stack
        ArrayDeque<ListNode> stack = new ArrayDeque();
        while(slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        // extract ListNode from stack and then connect to the front node
        fast = head;
        while(!stack.isEmpty()) {
            slow = stack.pop();
            ListNode tmp = fast.next;
            fast.next = slow;
            slow.next = tmp;
            fast = tmp;
        }
        slow.next = null;
    }

    /**
     * Solution 2: in-place, using some trick
     */
    public void reorderList2(ListNode head) {
        if(head == null || head.next == null) return;
        // Step 1: find a middle node
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // Step 2: reverse the second half of the list
        ListNode prev = null, curr = slow;
        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // Step 2: merge first half and second half of the list
        ListNode first = head, second = prev;
        while(second.next != null) {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}
