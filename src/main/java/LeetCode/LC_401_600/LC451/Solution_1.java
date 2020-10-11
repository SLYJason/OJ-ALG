package LeetCode.LC_401_600.LC451;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Solution 1: using PriorityQueue.
 */
public class Solution_1 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> pair = maxHeap.poll();
            char ch = pair.getKey();
            int count = pair.getValue();
            while(count-- > 0) sb.append(ch);
        }
        return sb.toString();
    }
}
