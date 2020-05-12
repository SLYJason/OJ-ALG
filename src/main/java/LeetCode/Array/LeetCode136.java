package LeetCode.Array;

import java.util.Arrays;

public class LeetCode136 {
    // Solution 1: intuitive solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i+=2) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    // Solution 2: suggested solution, use Bit Manipulation (XOR)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}


