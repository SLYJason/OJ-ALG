package LeetCode.HashMap;

import java.util.Map;
import java.util.HashMap;

public class LeetCode525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int maxLen = 0, prefixSum = 0;
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i] == 1 ? 1 : -1;
            if(prefixSum == 0) maxLen = i+1;
            if(map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
