package LeetCode.LC_601_800.LC692;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: max-heap.
 */
public class Solution_2 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a)); // Important: need to use .equals() to compare Integer objects.
        for (String word:words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry.getKey());
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll());
            if (res.size() == k) break;
        }
        return res;
    }
}
