package LeetCode.LC_201_400.LC246;

import java.util.HashMap;

/**
 * Solution 2: two pointers.
 */
public class Solution_2 {
    public boolean isStrobogrammatic(String num) {
        HashMap<Integer, Integer> map = new HashMap() {
            {
                put(0, 0);
                put(1, 1);
                put(6, 9);
                put(8, 8);
                put(9, 6);
            }
        };
        for(int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            int n = num.charAt(i) - '0';
            if(!map.containsKey(n)) return false;
            if(map.get(n) != num.charAt(j) - '0') return false;
        }
        return true;
    }
}
