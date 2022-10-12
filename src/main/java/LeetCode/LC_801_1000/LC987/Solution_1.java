package LeetCode.LC_801_1000.LC987;

import Shared.TreeNode;

import java.util.AbstractMap;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solution 1: BFS, same as LC314.
 */
public class Solution_1 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> colList = new TreeMap<>(); // K: column number of TreeNode. V: A list of TreeNode has this column number.
        List<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        // BFS.
        queue.add(new AbstractMap.SimpleEntry<>(root, 0));
        while (!queue.isEmpty()) {
            List<Map.Entry<TreeNode, Integer>> buffer = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                Map.Entry<TreeNode, Integer> entry = queue.remove(0);
                TreeNode node = entry.getKey();
                int col = entry.getValue();

                if (!colList.containsKey(col)) colList.put(col, new ArrayList<>());
                colList.get(col).add(node.val);
                if( node.left != null) buffer.add(new AbstractMap.SimpleEntry<>(node.left, col - 1));
                if (node.right != null) buffer.add(new AbstractMap.SimpleEntry<>(node.right, col + 1));
            }
            Collections.sort(buffer, (e1, e2) -> e1.getKey().val - e2.getKey().val);
            queue.addAll(buffer);
        }
        // Build the result.
        for (List<Integer> col : colList.values()) {
            res.add(col);
        }
        return res;
    }
}
