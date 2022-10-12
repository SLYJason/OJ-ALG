package Amazon.Onsite.Binary_Tree_Top_Down_View;

import Shared.TreeNode;
import java.util.List;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public List<Integer> verticalOrder(TreeNode root) {
        TreeMap<Integer, TreeNode> map = new TreeMap<>(); // key: column number of the node, value: tree node.
        Queue<NodeColumn> queue = new LinkedList<>();

        queue.offer(new NodeColumn(root, 0));
        while (!queue.isEmpty()) {
            NodeColumn cur = queue.poll();
            TreeNode node = cur.node;
            int col = cur.col;

            if (!map.containsKey(col)) {
                map.put(col, node);
            }

            if (node.left != null) queue.offer(new NodeColumn(node.left, col - 1));
            if (node.right != null) queue.offer(new NodeColumn(node.right, col + 1));
        }

        List<Integer> res = new LinkedList<>();
        for (TreeNode node : map.values()) {
            res.add(node.val);
        }
        return res;
    }

    class NodeColumn {
        TreeNode node;
        int col;
        public NodeColumn(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
