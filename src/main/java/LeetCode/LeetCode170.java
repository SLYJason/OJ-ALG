package LeetCode;

import java.util.Map;
import java.util.HashMap;

public class LeetCode170 {
    class TwoSum {
        Map<Integer, Integer> map;
        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap<Integer, Integer>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0)+1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for(Integer num1:map.keySet()) {
                int num2 = value - num1;
                if(num1 == num2 && map.get(num1) > 1 || num1 != num2 && map.containsKey(num2)) {
                    return true;
                }
            }
            return false;
        }
    }
}
