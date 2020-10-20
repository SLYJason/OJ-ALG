package LeetCode.LC_201_400.LC257;

import Shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Solution 2: optimal recursion.
 */
public class Solution_2 {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList();
        List<String> res = new ArrayList();
        preOrder(root, new StringBuilder(), res);
        return res;
    }

    private void preOrder(TreeNode root, StringBuilder path, List<String> res) {
        if(root == null) return;
        int len = path.length();
        path.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(path.toString());
        } else {
            path.append("->");
            preOrder(root.left, path, res);
            preOrder(root.right, path, res);
        }
        path.setLength(len);
    }
}
