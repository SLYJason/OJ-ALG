package LeetCode.LC_2001_2200.LC2096;

import Shared.TreeNode;

/**
 * Solution: LCA + DFS.
 */
public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return "";

        // step 1: find the LCA.
        TreeNode lca = findLCA(root, startValue, destValue);

        // step 2: find start -> lca and lca -> dest paths.
        StringBuilder startToLca = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        dfs(lca, startValue, startToLca);
        dfs(lca, destValue, lcaToDest);

        // step 3: convert start -> lca to all "U".
        int n = startToLca.length();
        startToLca.setLength(0);
        while (n-- > 0) startToLca.append("U");

        return startToLca.toString() + lcaToDest.toString();
    }

    public boolean dfs(TreeNode node, int value, StringBuilder sb) {
        if (node == null) return false;
        if (node.val == value) return true;

        sb.append("L");
        if (dfs(node.left, value, sb)) return true;
        sb.setLength(sb.length() - 1);

        sb.append("R");
        if (dfs(node.right, value, sb)) return true;
        sb.setLength(sb.length() - 1);

        return false;
    }


    public TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null) return null;
        if (root.val == startValue || root.val == destValue) return root;

        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);

        if (left != null && right != null) return root; // LCA found which is root.
        if (left == null && right == null) return null; // Both startValue and destValue not found.
        return left != null ? left : right; // either startValue or destValue found.
    }
}
