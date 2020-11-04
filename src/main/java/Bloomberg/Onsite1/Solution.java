package Bloomberg.Onsite1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Solution: BFS.
 */
public class Solution {
    public int minSteps(int n) {
        if(n <= 1) return 0; // base case.

        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>(); // reduce unnecessary steps.
        queue.offer(2); // only can add 1*2 here, since 1/3 = 0.
        visited.add(2);
        while(!queue.isEmpty()) {
            steps++;
            for(int i=queue.size(); i>0; i--) {
                int cur = queue.poll();
                if(cur == n) return steps; // find the results.

                int n1 = cur * 2;
                int n2 = cur / 3;
                if(visited.add(n1)) queue.offer(n1);
                if(visited.add(n2)) queue.offer(n2);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 3;

        Solution s = new Solution();
        System.out.println("n is: " + n1 + ", minimum steps is: " + s.minSteps(n1));
        System.out.println("n is: " + n2 + ", minimum steps is: " + s.minSteps(n2));
    }
}
