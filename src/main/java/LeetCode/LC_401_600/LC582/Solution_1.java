package LeetCode.LC_401_600.LC582;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<ppid.size(); i++) {
            int pp = ppid.get(i);
            if(!graph.containsKey(pp)) graph.put(pp, new ArrayList<>());
            graph.get(pp).add(pid.get(i));
        }
        res.add(kill);
        dfs(kill, graph, res);
        return res;
    }

    private void dfs(int ppid, Map<Integer, List<Integer>> graph, List<Integer> res) {
        if(graph.containsKey(ppid)) {
            for(int pid : graph.get(ppid)) {
                res.add(pid);
                dfs(pid, graph, res);
            }
        }
    }
}
