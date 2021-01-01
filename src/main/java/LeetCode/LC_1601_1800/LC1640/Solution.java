package LeetCode.LC_1601_1800.LC1640;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution: HashMap.
 */
public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] piece : pieces) map.put(piece[0], piece);
        int i = 0;
        while(i < arr.length) {
            if(!map.containsKey(arr[i])) return false;
            int[] piece = map.get(arr[i]);
            for(int p : piece) {
                if(arr[i] != p) return false;
                i++;
            }
        }
        return true;
    }
}
