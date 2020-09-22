package Amazon.OA3;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Solution: using HashMap to count the competitors, using PriorityQueue to sort competitors.
 * Same as LC692.
 */
public class Solution {
    public List<String> topNCompetitors(List<String> reviews, List<String> competitors, int topNCompetitors) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));
        for(String review : reviews) {
            for(String competitor : competitors) {
                if(review.contains(competitor)) {
                    map.put(competitor, map.getOrDefault(competitor, 0)+1);
                }
            }
        }
        // pq is a max-heap.
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry.getKey());
        }
        while(!pq.isEmpty()) {
            res.add(pq.poll());
            if(res.size() == topNCompetitors) break;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // test case 1.
        List<String> reviews1 = new LinkedList<String>(){
            {
                add("I love Google");
                add("I love Apple");
                add("I love Google more than Apple but Apple products are nice as well");
                add("Apple products are great");
                add("I love Microsoft");
            }
        };
        List<String> competitors1 = new LinkedList<String>(){
            {
                add("Google");
                add("Apple");
                add("Netflix");
                add("Microsoft");
            }
        };
        int topNCompetitors1 = 2;
        System.out.println(sol.topNCompetitors(reviews1, competitors1, topNCompetitors1));
        // test case 2.
        List<String> reviews2 = new LinkedList<String>(){
            {
                add("I love Google");
                add("I love Apple");
                add("I love Google more than Apple but Apple products are nice as well, same Baidu");
                add("Apple products are great");
                add("I love Microsoft");
                add("I love Baidu");
            }
        };
        List<String> competitors2 = new LinkedList<String>(){
            {
                add("Google");
                add("Apple");
                add("Netflix");
                add("Microsoft");
                add("Baidu");
            }
        };
        int topNCompetitors2 = 3;
        System.out.println(sol.topNCompetitors(reviews2, competitors2, topNCompetitors2));
    }
}
