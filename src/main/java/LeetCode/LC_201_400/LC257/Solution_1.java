package LeetCode.LC_201_400.LC257;

import Shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Solution 1: brute force recursion, intuitive thoughts.
 */
public class Solution_1 {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList();
        List<List<Integer>> list = new ArrayList();
        preOrder(root, new ArrayList(), list);
        List<String> res = new ArrayList();
        // build the results.
        for(List<Integer> sub : list) {
            StringBuilder sb = new StringBuilder();
            for(Integer num : sub) {
                sb.append(num + "->");
            }
            sb.delete(sb.length()-2, sb.length());
            res.add(sb.toString());
        }
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> cur, List<List<Integer>> list) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            cur.add(root.val);
            list.add(new ArrayList(cur));
            cur.remove(cur.size()-1);
            return;
        }
        cur.add(root.val);
        preOrder(root.left, cur, list);
        preOrder(root.right, cur, list);
        cur.remove(cur.size()-1);
    }
}
