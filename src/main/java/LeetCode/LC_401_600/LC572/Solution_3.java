package LeetCode.LC_401_600.LC572;

import Shared.TreeNode;

/**
 * Solution 3: recursive.
 */
public class Solution_3 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isIdentical(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }
}
