package LeetCode.LC384;

import java.util.Random;
import java.util.Arrays;

/**
 * Solution 2: Fisher-Yates Algorithm.
 * Time Complexity: O(N).
 * Space Complexity: O(N).
 */
public class Solution_2 {
    int[] ori;
    int[] nums;
    Random random;
    public Solution_2(int[] nums) {
        this.ori = nums;
        this.nums = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = Arrays.copyOf(ori, ori.length);
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=nums.length-1; i>0; i--) {
            int index = random.nextInt(i+1);
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
        return nums;
    }
}
