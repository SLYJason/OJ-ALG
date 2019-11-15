package LeetCode;

import java.util.Map;
import java.util.TreeMap;

public class LeetCode954 {
    class Solution {
        public boolean canReorderDoubled(int[] A) {
            Map<Integer, Integer> map = new TreeMap();
            for(int i : A) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for(int i : map.keySet()) {
                if (map.get(i) == 0) continue;
                int want = i < 0 ? i/2 : i*2;
                if (i < 0 && i % 2 != 0 || map.get(i) > map.getOrDefault(want, 0)){
                    return false;
                }
                map.put(want, map.get(want) - map.get(i));
            }
            return true;
        }
    }
}
