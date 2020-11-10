package LeetCode.LC_1_200.LC116;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: DFS.
 */
public class Solution_2 {
    List<List<Node>> levels = new ArrayList();
    public Node connect(Node root) {
        if(root == null) return null;
        preOrder(root, 0);
        for(List<Node> level : levels) {
            for(int i=0; i<level.size()-1; i++) {
                level.get(i).next = level.get(i+1);
            }
        }
        return root;
    }

    private void preOrder(Node root, int level) {
        if(root == null) return;
        if(levels.size() == level) levels.add(new ArrayList());
        levels.get(level).add(root);
        preOrder(root.left, level+1);
        preOrder(root.right, level+1);
    }
}

