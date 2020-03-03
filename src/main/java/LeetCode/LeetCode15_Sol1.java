package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * two-sum HashMap solution
 */
public class LeetCode15_Sol1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            // remove duplicates
            if(i > 0 && nums[i] == nums[i-1]) continue;
            // use two-sum for the rest of elements
            int remainingSum = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap();
            for(int j=i+1; j<nums.length; j++) {
                int third = remainingSum-nums[j];
                if(map.containsKey(third)) {
                    if(map.get(third)==1) {
                        List<Integer> triple = new ArrayList();
                        triple.add(nums[i]);
                        triple.add(third);
                        triple.add(nums[j]);
                        ans.add(triple);
                    }
                    map.put(third, map.get(third)+1);
                } else {
                    map.put(nums[j], 1);
                }
            }
        }
        return ans;
    }
}
