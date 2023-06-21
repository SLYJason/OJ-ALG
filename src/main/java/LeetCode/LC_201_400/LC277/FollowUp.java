package LeetCode.LC_201_400.LC277;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution: cache.
 */
public class FollowUp {
    public int findCelebrity(int n) {
        Map<Pair<Integer, Integer>, Boolean> map = new HashMap<>(); // K: pair (A,B), V: boolean value to identify A knows B or not.
        int celebrity = 0;
        // 1st pass.
        for(int i=1; i<n; i++) {
            boolean knows = knows(celebrity, i);
            map.put(new Pair(celebrity, i), knows);
            if(knows) {
                celebrity = i;
            }
        }
        // 2nd pass.
        for(int i=0; i<n; i++) {
            if(i == celebrity) continue;
            Pair pair1 = new Pair(celebrity, i);
            Pair pair2 = new Pair(i, celebrity);
            boolean knows1 = map.containsKey(pair1) ? map.get(pair1) : knows(celebrity, i);
            boolean knows2 = map.containsKey(pair2) ? map.get(pair2) : knows(i, celebrity);
            if(knows1 || !knows2) return -1;
        }
        return celebrity;
    }

    // The knows API is defined in the parent class Relation.
    boolean knows(int a, int b) {
        return true;
    }
}

class Pair<K, V> {
    K key;
    V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
