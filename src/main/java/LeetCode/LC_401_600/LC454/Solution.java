package LeetCode.LC_401_600.LC454;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution: two sum logic.
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length < 1) return 0;
        int n = A.length;
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int complement = 0 - A[i] - B[j];
                map.put(complement, map.getOrDefault(complement, 0)+1);
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                res += map.getOrDefault(C[i]+D[j], 0);
            }
        }
        return res;
    }
}
