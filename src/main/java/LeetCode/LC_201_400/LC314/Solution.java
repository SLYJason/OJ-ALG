package LeetCode.LC_201_400.LC314;

import Shared.TreeNode;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: BFS.
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        Map<Integer, List<Integer>> columnList = new HashMap(); // K: column, V: a list of value belongs to this column number.
        Queue<NodeColumn> queue = new LinkedList();
        int min_col = 0; // the leftmost column number, can be negative value.
        int max_col = 0; // the rightmost column number, can be positive value.

        // BFS traversal.
        queue.offer(new NodeColumn(root, 0));
        while(!queue.isEmpty()) {
            NodeColumn cur = queue.poll();
            TreeNode node = cur.node;
            int col = cur.col;

            // put value belongs to this column into columnList.
            if(!columnList.containsKey(col)) columnList.put(col, new ArrayList());
            columnList.get(col).add(node.val);

            min_col = Math.min(min_col, col);
            max_col = Math.max(max_col, col);
            if(node.left != null) queue.offer(new NodeColumn(node.left, col-1));
            if(node.right != null) queue.offer(new NodeColumn(node.right, col+1));
        }

        // build the final result.
        List<List<Integer>> res = new ArrayList();
        for(int i=min_col; i<=max_col; i++) {
            res.add(columnList.get(i));
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
