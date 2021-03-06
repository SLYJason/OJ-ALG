package LeetCode.Graph;

import java.util.Arrays;

/**
 * Solution 3: Union-Find.
 */
public class LeetCode261_Sol3 {
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, (c1, c2) -> (c1[2] - c2[2])); // sort edge cost in ascending order.
        UnionFind uf = new UnionFind(N);
        int min_cost = 0;
        for(int[] connection : connections) {
            int n1 = connection[0], n2 = connection[1], cost = connection[2];
            if(uf.union(n1, n2)) {
                N--;
                min_cost += cost;
            }
        }
        return N == 1 ? min_cost : -1;
    }


    class UnionFind {
        int[] parents;

        public UnionFind(int N) {
            parents = new int[N+1];
            for(int i=1; i<N+1; i++) parents[i] = i;
        }

        public int find(int x) {
            if(parents[x] == x) return x;
            parents[x] = find(parents[x]); // path compression
            return parents[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px == py) return false;
            parents[px] = py;
            return true;
        }
    }
}
