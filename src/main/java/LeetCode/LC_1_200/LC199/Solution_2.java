package LeetCode.LC_1_200.LC199;

import Shared.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: DFS.
 */
public class Solution_2 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList();
        List<Integer> res = new ArrayList();
        rightView(root, 0, res);
        return res;
    }

    private void rightView(TreeNode root, int level, List<Integer> res) {
        if(level == res.size()) {
            res.add(root.val);
        }
        if(root.right != null) rightView(root.right, level+1, res); // go right first.
        if(root.left != null) rightView(root.left, level+1, res);
    }
}
