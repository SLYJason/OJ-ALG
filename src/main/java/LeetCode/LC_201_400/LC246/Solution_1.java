package LeetCode.LC_201_400.LC246;

import java.util.Map;

/**
 * Solution 1: HashMap.
 */
public class Solution_1 {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> map = Map.of(0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
        StringBuilder sb = new StringBuilder();
        for(int i = num.length() - 1; i >= 0; i--) {
            int n = num.charAt(i) - '0';
            if(!map.containsKey(n)) return false;
            sb.append(map.get(n));
        }
        return sb.toString().equals(num);
    }
}
