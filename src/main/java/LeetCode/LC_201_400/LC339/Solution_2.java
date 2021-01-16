package LeetCode.LC_201_400.LC339;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

/**
 * Solution 1: BFS.
 */
public class Solution_2 {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        int depth = 0, sum = 0;
        for(NestedInteger n : nestedList) queue.offer(n);
        while(!queue.isEmpty()) {
            depth++;
            for(int i=queue.size(); i>0; i--) {
                NestedInteger n = queue.poll();
                if(n.isInteger()) {
                    sum += n.getInteger() * depth;
                } else {
                    queue.addAll(n.getList());
                }
            }
        }
        return sum;
    }
}
