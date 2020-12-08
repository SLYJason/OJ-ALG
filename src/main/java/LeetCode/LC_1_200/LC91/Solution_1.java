package LeetCode.LC_1_200.LC91;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: DFS + Memorization.
 */
public class Solution_1 {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return numDecodings(0, s, new HashMap());
    }

    public int numDecodings(int index, String s, Map<Integer, Integer> memo) {
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0; // no way to decode 0.
        if(memo.containsKey(index)) return memo.get(index);
        int way1 = numDecodings(index+1, s, memo);

        int way2 = 0;
        if(index+2 <= s.length() && Integer.parseInt(s.substring(index, index+2)) <= 26) {
            way2 = numDecodings(index+2, s, memo);
        }
        memo.put(index, way1 + way2);
        return way1 + way2;
    }
}
