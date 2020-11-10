package LeetCode.LC_201_400.LC269;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution 2: DFS, using LC210 logic.
 */
public class Solution_2 {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap();
        Map<Character, Integer> states = new HashMap(); // 0: unvisited, 1: visiting, 2: visited.
        // Initialization.
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                graph.put(ch, new ArrayList());
                states.put(ch, 0);
            }
        }
        // Step 1: build the graph.
        for(int i=0; i<words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return ""; // Case 1.
            for(int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }
        // Step 2: DFS
        StringBuilder sb = new StringBuilder();
        for(char ch : graph.keySet()) {
            if(hasCyclic(ch, graph, states, sb)) return "";
        }
        return sb.reverse().toString();
    }

    private boolean hasCyclic(char cur, Map<Character, List<Character>> graph, Map<Character, Integer> states, StringBuilder sb) {
        if(states.get(cur) == 1) return true;
        if(states.get(cur) == 2) return false;
        states.put(cur, 1);

        for(char neighbor : graph.get(cur)) {
            if(hasCyclic(neighbor, graph, states, sb)) return true;
        }
        states.put(cur, 2);
        sb.append(cur);
        return false;
    }
}
