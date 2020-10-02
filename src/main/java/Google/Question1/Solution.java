package Google.Question1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int numberOfTriangles(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for(int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            for(List<Integer> list : graph) {
                if(list.contains(nodeA) && list.contains(nodeB)) count++;
            }
        }
        return count/3; // for each edge, we calculate 3 times so need to divide by 3.
    }

    public static void main(String[] args) {
        int n1 = 6;
        int[][] edges1 = {{0, 1}, {3, 0}, {0, 2}, {3, 2}, {1, 2}, {4, 0}, {3, 4}, {3, 5}, {4, 5}, {1, 5}, {1, 3}};
        int n2 = 4;
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 0}};
        Solution solution = new Solution();
        System.out.println(solution.numberOfTriangles(n1, edges1));
        System.out.println(solution.numberOfTriangles(n2, edges2));
    }
}
