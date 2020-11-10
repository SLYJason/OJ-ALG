package LeetCode.LC_201_400.LC269;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: topological sorting.
 */
public class Solution_1 {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap();
        Map<Character, Integer> in_degree = new HashMap();
        // Initialization.
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                graph.put(ch, new ArrayList());
                in_degree.put(ch, 0);
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
                    in_degree.put(c2, in_degree.get(c2) + 1);
                    break;
                }
            }
        }
        // Step 2: insert character with degree 0 into queue.
        Queue<Character> queue = new LinkedList();
        for(Map.Entry<Character, Integer> entry : in_degree.entrySet()) {
            if(entry.getValue() == 0) queue.offer(entry.getKey());
        }
        // Step 3: BFS.
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            for(Character neighbor : graph.get(ch)) {
                in_degree.put(neighbor, in_degree.get(neighbor)-1);
                if(in_degree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        //System.out.println(queue);
        if(sb.length() != graph.size()) return ""; // Case 2.
        return sb.toString();
    }
}
