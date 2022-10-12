package LeetCode.LC_801_1000.LC987;

import Shared.TreeNode;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Solution 2: DFS + Sorting.
 */
public class Solution_2 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<NodePosition> nodeList = new ArrayList<>();
        // Step 1: DFS traverse the tree, push nodes to nodeList.
        dfs(root, 0, 0, nodeList);

        // Step 2: sorting the nodeList.
        Collections.sort(nodeList, new Comparator<NodePosition>() {
            @Override
            public int compare(NodePosition n1, NodePosition n2) {
                if(n1.column == n2.column) {
                    if(n1.row == n2.row) return n1.val - n2.val; // same position, sort by node value.
                    return n1.row - n2.row; // same column, sort by row.
                }
                return n1.column - n2.column; // sort by column.
            }
        });

        // Step 3: build the result.
        int currColumn = nodeList.get(0).column;
        res.add(new ArrayList<>());
        for (NodePosition nodePosition : nodeList) {
            if (currColumn != nodePosition.column) {
                currColumn = nodePosition.column;
                res.add(new ArrayList<>());
            }
            res.get(res.size() - 1).add(nodePosition.val);
        }
        return res;
    }

    private void dfs(TreeNode root, int r, int c, List<NodePosition> nodeList) {
        if(root == null) return;
        nodeList.add(new NodePosition(r, c, root.val));
        dfs(root.left, r + 1, c - 1, nodeList);
        dfs(root.right, r + 1, c + 1, nodeList);
    }

    class NodePosition {
        public int row;
        public int column;
        public int val;
        public NodePosition(int r, int c, int v) {
            row = r;
            column = c;
            val = v;
        }
    }
}
