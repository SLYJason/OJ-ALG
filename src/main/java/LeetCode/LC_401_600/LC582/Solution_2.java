package LeetCode.LC_401_600.LC582;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution 2: BFS.
 */
public class Solution_2 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<ppid.size(); i++) {
            int pp = ppid.get(i);
            if(!graph.containsKey(pp)) graph.put(pp, new ArrayList<>());
            graph.get(pp).add(pid.get(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while(!queue.isEmpty()) {
            int pp = queue.poll();
            res.add(pp);
            if(graph.containsKey(pp)) {
                for(int pi : graph.get(pp)) {
                    queue.offer(pi);
                }
            }
        }
        return res;
    }
}
