package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * two-pointer solution
 */
public class LeetCode15_Sol2 {
    public List<List<Integer>> threeSum(int[] nums) {
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
