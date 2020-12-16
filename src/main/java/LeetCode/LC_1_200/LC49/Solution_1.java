package LeetCode.LC_1_200.LC49;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution 1: hashmap + sorting.
 */
public class Solution_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList();
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] S = s.toCharArray();
            Arrays.sort(S);
            String key = new String(S);
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
