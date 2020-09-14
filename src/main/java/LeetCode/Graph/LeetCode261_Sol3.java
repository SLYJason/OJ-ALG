package LeetCode.Graph;

import java.util.Arrays;

/**
 * Solution 3: Union-Find.
 */
public class LeetCode261_Sol3 {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) return false;
        // Condition 2: The graph must fully connected.
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if(!uf.union(x, y)) return false; // cycle detected.
        }
        return true;
    }

    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        public int find(int num) {
            int parent = this.parent[num];
            if(parent == -1) return num;
            return find(parent);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return false;
            parent[rootX] = rootY;
            return true;
        }
    }
}
