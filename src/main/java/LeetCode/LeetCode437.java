package LeetCode;

public class LeetCode437 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int dfs(TreeNode root, int sum) {
        if(root == null) return 0;
        int count = 0;
        if(root.val == sum) count++;
        count += dfs(root.left, sum-root.val) + dfs(root.right, sum-root.val);
        return count;
    }
}
