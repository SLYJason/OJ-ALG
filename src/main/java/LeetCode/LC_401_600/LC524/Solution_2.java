package LeetCode.LC_401_600.LC524;

import java.util.List;

/**
 * Solution 2: without sorting.
 */
public class Solution_2 {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for(String ds : d) {
            int i = 0, j = 0;
            while(i < s.length() && j < ds.length()) {
                if(s.charAt(i) == ds.charAt(j)) {
                    j++;
                }
                i++;
            }
            if(j == ds.length()) {
                if(ds.length() > res.length() || (ds.length() == res.length() && ds.compareTo(res) < 0)) res = ds;
            }
        }
        return res;
    }
}
