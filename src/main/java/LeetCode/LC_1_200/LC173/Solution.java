package LeetCode.LC_1_200.LC173;

import Shared.TreeNode;
import java.util.NoSuchElementException;
import java.util.ArrayDeque;

/**
 * Solution: using controlled iterative dfs.
 */
public class Solution {
    class BSTIterator {
        ArrayDeque<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new ArrayDeque();
            push(root);
        }

        /** @return the next smallest number */
        public int next() {
            if(!hasNext()) throw new NoSuchElementException();
            TreeNode node = stack.pop();
            int next = node.val;
            push(node.right);
            return next;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // push current node and its left subtree to stack.
        private void push(TreeNode root) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }
}
