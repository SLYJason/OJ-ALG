package LeetCode.LC_601_800.LC692;

import java.util.*;

public class FollowUp {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b)); // Important: need to use .equals() to compare Integer objects.
        for (String word:words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() >= k && Objects.equals(map.get(pq.peek()), map.get(entry.getKey()))) {
                pq.offer(entry.getKey());
                continue;
            }
            pq.offer(entry.getKey());
            if (pq.size() > k) pq.poll();
        }
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words1 = {"i","love","coding","i","love","coding"};
        System.out.println(topKFrequent(words1, 1));
        System.out.println(topKFrequent(words1, 2));
        System.out.println(topKFrequent(words1, 3));

        String[] words2 = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words2, 1));
        System.out.println(topKFrequent(words2, 2));
        System.out.println(topKFrequent(words2, 3));
    }
}
