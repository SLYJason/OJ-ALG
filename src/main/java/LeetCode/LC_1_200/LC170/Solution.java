package LeetCode.LC_1_200.LC170;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: quick add.
 */
public class Solution {
    class TwoSum {
        Map<Integer, Integer> map; // K: number, V: count of number.
        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0)+1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();
                int complement = value - num;
                if(complement != num && map.containsKey(complement)) return true;
                if(complement == num && count > 1) return true;
            }
            return false;
        }
    }
}
