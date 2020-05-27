package LeetCode.Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class LeetCode886_Sol2 {
    List<Integer>[] graph;
    Map<Integer, Integer> colorMap = new HashMap();
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList();
        for(int[] dis : dislikes) {
            graph[dis[0]].add(dis[1]);
            graph[dis[1]].add(dis[0]);
        }

        for(int i=1; i<N+1; i++) {
            if(!colorMap.containsKey(i)) {
                colorMap.put(i, 0);
                Queue<Integer> queue = new LinkedList();
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int curr = queue.poll();
                    for(int neighbor : graph[curr]) {
                        if(colorMap.containsKey(neighbor)) {
                            if(colorMap.get(curr) == colorMap.get(neighbor)) return false;
                        } else {
                            colorMap.put(neighbor, colorMap.get(curr) ^ 1);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return true;
    }
}
