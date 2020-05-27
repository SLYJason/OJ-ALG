package LeetCode.Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LeetCode886_Sol1 {
    // DFS solution
    List<Integer>[] graph;
    Map<Integer, Integer> colorMap = new HashMap();
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList();
        for(int[] dis : dislikes) {
            graph[dis[0]].add(dis[1]);
            graph[dis[1]].add(dis[0]);
        }

        // use 0, 1 to designate different color
        for(int i=1; i<N+1; i++) {
            // colorMap.containsKey(i): node has not been colored and then do dfs check
            if(!colorMap.containsKey(i) && !dfs(i, 0)) return false;
        }
        return true;
    }

    private boolean dfs(int node, int color) {
        if(colorMap.containsKey(node)) return colorMap.get(node) == color;
        colorMap.put(node, color);

        // color ^ 1 means get the contrary color
        for(int neighbor : graph[node]) {
            if(!dfs(neighbor, color ^ 1)) return false;
        }
        return true;
    }
}
