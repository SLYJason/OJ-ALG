package LeetCode.LC_401_600.LC572;

import Shared.TreeNode;

/**
 * Solution 1: using preOrder to serialize both trees, compare t is a substring of s.
 */
public class Solution_1 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        serialize(s, sb1);
        serialize(t, sb2);
        return sb1.toString().contains(sb2.toString());
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null,");
            return;
        }
        // reason to use # here: if s=[12], t=[2],
        // not using # serialization: 12,null,null, and 2,null,null,
        // using # serialization: #12,null,null, and #2,null,null,
        sb.append("#" + node.val + ",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}
