package LeetCode.HashMap;

import java.util.Map;
import java.util.HashMap;

public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        Map<Integer, Integer> prefixRem = new HashMap(); // K: cumulative sum % k at index i, V: index.
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(k != 0) {
                sum = sum % k;
            }
            if(prefixRem.containsKey(sum)) {
                if(i - prefixRem.get(sum) > 1) return true;
            } else {
                prefixRem.put(sum, i);
            }
            if(sum == 0 && i > 0) return true; // also similar: prefixRem.put(0, -1).
        }
        return false;
    }
}
