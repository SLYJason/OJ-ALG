package LeetCode.LC_1_200.LC95;

import Shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Solution: recursion.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        for(int i=start; i<=end; i++) {
            List<TreeNode> left = build(start, i-1);
            List<TreeNode> right = build(i+1, end);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
