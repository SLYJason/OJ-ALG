package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList();
        dfs(root, sum, ans, new ArrayList());
        return ans;
    }
    private void dfs(TreeNode node, int sum, List<List<Integer>> ans, List<Integer> pathNodes) {
        if(node == null) return;
        sum -= node.val;
        pathNodes.add(node.val);
        if(node.left == null && node.right == null && sum == 0) {
            // Should create a copy of pathNodes since we still need to modify it in the rest of operations.
            ans.add(new ArrayList(pathNodes));
        } else {
            dfs(node.left, sum, ans, pathNodes);
            dfs(node.right, sum, ans, pathNodes);
        }
        pathNodes.remove(pathNodes.size()-1);
    }
}
