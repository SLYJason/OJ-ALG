package LeetCode.LC_1_200.LC49;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: encoding.
 */
public class Solution_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            String key = "";
            for(Character ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                key += count[i] + "#";
            }
             if (!map.containsKey(key)) map.put(key, new ArrayList<>());
             map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
