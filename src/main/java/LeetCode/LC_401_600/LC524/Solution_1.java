package LeetCode.LC_401_600.LC524;

import java.util.List;
import java.util.Collections;

/**
 * Solution 1: sorting.
 */
public class Solution_1 {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (s1, s2) -> {
            if(s1.length() == s2.length()) return s1.compareTo(s2);
            return s2.length() - s1.length();
        });
        for(String ds : d) {
            int i = 0, j = 0;
            while(i < s.length() && j < ds.length()) {
                if(s.charAt(i) == ds.charAt(j)) {
                    j++;
                }
                i++;
            }
            if(j == ds.length()) return ds;
        }
        return "";
    }
}
