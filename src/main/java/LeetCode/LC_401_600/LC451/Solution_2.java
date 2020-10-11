package LeetCode.LC_401_600.LC451;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: bucket sort.
 */
public class Solution_2 {
    public String frequencySort(String s) {
        if(s.length() < 3) return s;
        // count each Character frequency.
        Map<Character, Integer> map = new HashMap();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        // bucket sort.
        int maxFrequency = Collections.max(map.values());
        List<Character>[] buckets = new List[maxFrequency+1];
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            if(buckets[freq] == null) buckets[freq] = new ArrayList();
            buckets[freq].add(ch);
        }
        // build the results.
        StringBuilder sb = new StringBuilder();
        for(int i=buckets.length-1; i>0; i--) {
            if(buckets[i] != null) {
                List<Character> list = buckets[i];
                for(Character ch : list) {
                    for(int j=0; j<i; j++) sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
