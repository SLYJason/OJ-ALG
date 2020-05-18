package LeetCode.HashMap;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LeetCode49 {
    // Time Complexity: O(KN), N is the length of strs, K is the maximum length of a string in strs
    // Space Complexity: O(KN)
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap();
        for(String str : strs) {
            int[] count = new int[26];
            String key = "";
            for(Character ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            for(int i=0; i<count.length; i++) {
                key += count[i] + "#";
            }
             if(!map.containsKey(key)) map.put(key, new ArrayList());
             map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
