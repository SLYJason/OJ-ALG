package LeetCode.LC_601_800.LC653;

import Shared.TreeNode;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        return preOrder(root, k, new HashSet());
    }

    private boolean preOrder(TreeNode root, int k, Set<Integer> complements) {
        if(root == null) return false;
        if(complements.contains(root.val)) return true;
        complements.add(k - root.val);
        return preOrder(root.left, k, complements) || preOrder(root.right, k, complements);
    }
}
