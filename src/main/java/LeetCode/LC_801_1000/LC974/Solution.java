package LeetCode.LC_801_1000.LC974;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution: prefix sum.
 */
public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for(int i=0; i<A.length; i++) {
            sum += A[i];
            if(sum % K == 0) res++;
            int mod = sum % K;
            if(mod < 0) mod += K; // transform mod to positive value.
            if(map.containsKey(mod)) {
                res += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        return res;
    }
}
