package LeetCode.LC_201_400.LC246;

import java.util.Map;

/**
 * Solution 2: two pointers.
 */
public class Solution_2 {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> map = Map.of(0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
        for(int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            int n = num.charAt(i) - '0';
            if(!map.containsKey(n)) return false;
            if(map.get(n) != num.charAt(j) - '0') return false;
        }
        return true;
    }
}
