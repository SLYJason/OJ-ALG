package LeetCode.Tree;

import Shared.TreeNode;
import java.util.List;
import java.util.LinkedList;

/**
 * Optimal Solution: using O(1) space, meet the follow up requirements.
 */
public class LeetCode501 {
    private Integer prev = null; // previous node value
    private int currCount = 1;
    private int maxCount = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> list = new LinkedList();
        inOrder(root, list);
        // covert List<Integer> to int[]
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        inOrder(node.left, list);
        if(prev != null) {
            if(node.val == prev) {
                currCount++;
            } else {
                currCount = 1;
            }
        }
        if(currCount == maxCount) {
            list.add(node.val);
        } else if(currCount > maxCount) {
            maxCount = currCount;
            list.clear();
            list.add(node.val);
        }
        prev = node.val;
        inOrder(node.right, list);
    }
}
