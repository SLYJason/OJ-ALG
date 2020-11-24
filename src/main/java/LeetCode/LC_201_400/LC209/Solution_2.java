package LeetCode.LC_201_400.LC209;

/**
 * Solution 2: sliding window.
 */
public class Solution_2 {
    public int minSubArrayLen(int s, int[] nums) {
        int min_length = Integer.MAX_VALUE;
        int i=0, j=0, sum=0;
        while(j < nums.length) {
            sum += nums[j++];
            while(sum >= s) {
                min_length = Math.min(min_length, j-i);
                sum -= nums[i++];
            }
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}
