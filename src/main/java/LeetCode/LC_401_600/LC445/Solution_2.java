package LeetCode.LC_401_600.LC445;

import Shared.ListNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution 2: using two Stack.
 */
public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque();
        Deque<Integer> stack2 = new ArrayDeque();
        push(l1, stack1);
        push(l2, stack2);

        int carry = 0;
        ListNode head = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            int n1 = stack1.isEmpty() ? 0 : stack1.pop();
            int n2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = n1 + n2 + carry;

            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = head;
            head = cur;
        }
        if(carry == 1) {
            ListNode cur = new ListNode(1);
            cur.next = head;
            head = cur;
        }
        return head;
    }

    private void push(ListNode l, Deque<Integer> stack) {
        while(l != null) {
            stack.push(l.val);
            l = l.next;
        }
    }
}
