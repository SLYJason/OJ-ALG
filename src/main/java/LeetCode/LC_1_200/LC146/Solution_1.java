package LeetCode.LC_1_200.LC146;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: brute force, intuitive thoughts
 */
public class Solution_1 {
    class LRUCache {
        Map<Integer, int[]> cache;
        int cacheAge;
        int capacity;

        public LRUCache(int capacity) {
            this.cache = new HashMap();
            this.cacheAge = -1;
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!cache.containsKey(key)) return -1;
            int[] pair = cache.get(key);
            pair[1] = ++cacheAge;
            return pair[0];
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)) {
                int[] pair = cache.get(key);
                pair[0] = value;
                pair[1] = ++cacheAge;
                return;
            }
            if(cache.size() == capacity) {
                int minAge = Integer.MAX_VALUE, minKey = Integer.MAX_VALUE;
                for(Map.Entry<Integer, int[]> entry : cache.entrySet()) {
                    if(entry.getValue()[1] < minAge) {
                        minAge = entry.getValue()[1];
                        minKey = entry.getKey();
                    }
                }
                cache.remove(minKey);
                cache.put(key, new int[]{value, ++cacheAge});
            } else {
                cache.put(key, new int[]{value, ++cacheAge});
            }
        }
    }
}
