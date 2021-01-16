package LeetCode.LC_201_400.LC339;

import java.util.List;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(NestedInteger n : nestedList) {
            if(n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += dfs(n.getList(), depth + 1);
            }
        }
        return sum;
    }
}
