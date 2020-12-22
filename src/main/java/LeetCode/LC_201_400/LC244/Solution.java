package LeetCode.LC_201_400.LC244;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution: HashMap
 */
public class Solution {
    class WordDistance {
        Map<String, List<Integer>> map;
        public WordDistance(String[] words) {
            map = new HashMap<>();
            for(int i=0; i<words.length; i++) {
                if(!map.containsKey(words[i])) map.put(words[i], new ArrayList());
                map.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int i=0, j=0, min = Integer.MAX_VALUE;
            while(i < list1.size() && j < list2.size()) {
                min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
                if(list1.get(i) < list2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return min;
        }
    }
}
