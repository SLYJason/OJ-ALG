package LeetCode.LC_1201_1400.LC1379;

import Shared.TreeNode;

/**
 * Solution 2: recursive.
 */
public class Solution_2 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        if(original == target) return cloned;
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        return res != null ? res : getTargetCopy(original.right, cloned.right, target);
    }
}
