package LeetCode.LC_201_400.LC398;

import java.util.Random;

/**
 * Solution 2: reservoir sampling.
 */
public class Solution_2 {
    class Solution {
        int[] nums;
        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int count = 0;
            int index = 0;
            Random random = new Random();
            for(int i=0; i<nums.length; i++) {
                if(nums[i] == target) {
                    count++;
                    if(random.nextInt(count) == 0) index = i;
                }
            }
            return index;
        }
    }
}
