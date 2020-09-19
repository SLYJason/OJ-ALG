package LeetCode.LC819;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class LeetCode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[ ;,.?!']+");
        Set<String> dict = new HashSet();
        for(String ban : banned) dict.add(ban);
        Map<String, Integer> map = new HashMap();
        String ans = "";
        int max = 0;
        for(String word : words) {
            map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0)+1);
            if(map.get(word.toLowerCase()) > max && !dict.contains(word.toLowerCase())) {
                max = map.get(word.toLowerCase());
                ans = word.toLowerCase();
            }
        }
        return ans;
    }
}
