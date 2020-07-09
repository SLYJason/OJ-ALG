package LeetCode.Tree;

import Shared.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution 2: DFS
 */
public class LeetCode662_Sol2 {
    int maxWidth;
    // (k, v) pair, k means current binary tree level, v means current node's index
    Map<Integer, Integer> map;
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        map = new HashMap();
        dfs(root, 0, 0);
        return maxWidth;
    }


    private void dfs(TreeNode node, int level, int index) {
        if(node == null) return;
        if(!map.containsKey(level)) {
            map.put(level, index);
        }
        maxWidth = Math.max(maxWidth, index - map.get(level) + 1);
        dfs(node.left, level+1, index*2);
        dfs(node.right,level+1, index*2+1);
    }
}
