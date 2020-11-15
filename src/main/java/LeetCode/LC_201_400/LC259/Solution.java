package LeetCode.LC_201_400.LC259;
import java.util.Arrays;

/**
 * Solution: two-pointers.
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i=0; i<nums.length-2; i++) {
            int sum = target - nums[i];
            int left = i+1, right = nums.length-1;
            // two-pointers logic.
            while(left < right) {
                if(nums[left] + nums[right] < sum) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
