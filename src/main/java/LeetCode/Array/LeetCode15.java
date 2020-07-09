package LeetCode.Array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LeetCode15 {
    /**
     * two-sum HashMap solution
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            // remove duplicates
            if(i > 0 && nums[i] == nums[i-1]) continue;
            // use two-sum for the rest of elements
            int remainingSum = 0 - nums[i];
            // (k, v) pair: k means nums[j], v means number of occurrence of nums[j]
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

    /**
     * two-pointer solution
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(i >0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = nums.length-1, sum = 0-nums[i];
            while(left < right) {
                if(nums[left]+nums[right] == sum) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // remove duplicates
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (nums[left]+nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
