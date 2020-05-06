package LeetCode.Array;

import java.util.Arrays;

public class LeetCode169 {
    // Solution 1: Boyer-Moore Voting Algorithm
    public int majorityElement1(int[] nums) {
        int m = nums[0], counter = 1;
        for(int i=1; i<nums.length; i++) {
            if(counter == 0) {
                m = nums[i];
                counter = 1;
            } else if (m == nums[i]) {
                counter++;
            } else {
                counter--;
            }
        }
        return m;
    }

    // Solution 2
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
