package LeetCode.LC_201_400.LC332;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: DFS.
 */
public class Solution {
    // The reason to use PriorityQueue is we want to visit smaller lexical order airport first.
    Map<String, PriorityQueue<String>> graph = new HashMap(); // K: airport, V: A list of airport destinations.
    List<String> res = new ArrayList();
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build the graph.
        for(List<String> ticket : tickets) {
            String start = ticket.get(0), end = ticket.get(1);
            if(graph.get(start) == null) graph.put(start, new PriorityQueue());
            graph.get(start).offer(end);
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String start) {
        PriorityQueue<String> ends = graph.get(start);
        while(ends != null && !ends.isEmpty()) {
            String end = ends.poll();
            dfs(end);
        }
        res.add(0, start);
    }
}
