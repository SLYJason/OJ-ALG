package LeetCode.LC_201_400.LC297;

import Shared.TreeNode;
import java.util.List;
import java.util.LinkedList;

/**
 * Solution: using DFS preOrder to serialize, deserialize.
 */
public class Solution {
    String res = "";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            res += "null,";
        } else {
            res += root.val + ",";
            dfs(root.left);
            dfs(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        List<String> list = new LinkedList();
        String[] arr = data.split(",");
        for(String node : arr) list.add(node);
        return des(list);
    }

    private TreeNode des(List<String> list) {
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = des(list);
        root.right = des(list);
        return root;
    }
}
