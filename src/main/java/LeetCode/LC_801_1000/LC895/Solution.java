package LeetCode.LC_801_1000.LC895;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayDeque;

/**
 * Solution: HashMap.
 */
public class Solution {
    class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, ArrayDeque<Integer>> group;
        int max_freq;
        public FreqStack() {
            freq = new HashMap<>();
            group = new HashMap<>();
            max_freq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            max_freq = Math.max(max_freq, freq.get(x));
            if(!group.containsKey(freq.get(x))) group.put(f, new ArrayDeque<>());
            group.get(f).push(x);
        }

        public int pop() {
            int max = group.get(max_freq).pop();
            freq.put(max, max_freq - 1);
            if(group.get(max_freq).size() == 0) group.remove(max_freq--);
            return max;
        }
    }
}
