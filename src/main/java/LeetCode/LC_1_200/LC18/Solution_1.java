package LeetCode.LC_1_200.LC18;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: same logic as LC15 3SUM.
 */
public class Solution_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return new ArrayList();
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue; // remove duplicates.
            for(int j=i+1; j<nums.length-2; j++) {
                if(j > i+1 && nums[j-1] == nums[j]) continue; // remove duplicates.
                int twoSum = target - nums[i] - nums[j];
                int left = j+1, right = nums.length-1;
                while(left < right) {
                    if(nums[left] + nums[right] == twoSum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++; // remove duplicates.
                        while(left < right && nums[right] == nums[right-1]) right--; // remove duplicates.
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] < twoSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
