package LeetCode.Design;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class LeetCode381 {
    class RandomizedCollection {
        Map<Integer, Set<Integer>> map;
        List<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap();
            list = new ArrayList();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contains = map.containsKey(val);
            if(!contains) map.put(val, new LinkedHashSet());
            map.get(val).add(list.size());
            list.add(val);
            return contains;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            // swap val with the last element if val is not the last one
            if(list.get(list.size()-1) != val) {
                int valIdx = map.get(val).iterator().next();
                int lastEle = list.get(list.size()-1);
                list.set(valIdx, lastEle);
                list.set(list.size()-1, val);
                map.get(val).remove(valIdx);
                map.get(val).add(list.size()-1);
                map.get(lastEle).add(valIdx);
                map.get(lastEle).remove(list.size()-1);
            }
            map.get(val).remove(list.size()-1);
            if(map.get(val).isEmpty()) map.remove(val);
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
