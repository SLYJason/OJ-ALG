package LeetCode.LC_201_400.LC210;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Solution 1: Khan's algorithm, Topological Sorting.
 */
public class Solution_1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int index = 0;
        List<List<Integer>> graph = new ArrayList();
        int[] in_degree = new int[numCourses];
        for(int i=0; i<numCourses; i++) graph.add(new ArrayList());
        for(int[] p : prerequisites) {
            in_degree[p[0]]++;
            graph.get(p[1]).add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(in_degree[i] == 0) queue.offer(i); // in_degree with 0 added to the queue, means this value has zero dependency.
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            res[index++] = course;
            for(int neighbor : graph.get(course)) {
                if(--in_degree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}
