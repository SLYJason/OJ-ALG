package LeetCode.LC_201_400.LC323;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 3: union find.
 */
public class Solution_3 {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        for(int i=0; i<n; i++) parents[i] = i;
        // union
        for(int[] edge : edges) union(parents, edge[0], edge[1]);
        // find unique parents.
        Set<Integer> set = new HashSet();
        for(int i=0; i<n; i++) {
            set.add(find(parents, i));
        }
        return set.size();
    }

    private int find(int[] parents, int x) {
        if(parents[x] == x) return x;
        parents[x] = find(parents, parents[x]); // path compression.
        return parents[x];
    }

    private void union(int[] parents, int x, int y) {
        int px = find(parents, x);
        int py = find(parents, y);
        parents[px] = py;
    }
}
