package LeetCode.Design;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class LeetCode380 {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap();
            list = new ArrayList();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            int idx = map.get(val);
            // swap val with the last element in the list
            int lastEle = list.get(list.size()-1);
            list.set(idx, lastEle);
            list.set(list.size()-1, val);
            map.put(lastEle, idx);
            // remove the val
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }
}
