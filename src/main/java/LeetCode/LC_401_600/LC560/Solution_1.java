package LeetCode.LC_401_600.LC560;

/**
 * Solution 1: brute force
 */
public class Solution_1 {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        for(int i=0; i<nums.length; i++) {
            int j=i, sum=0;
            while(j<nums.length) {
                sum += nums[j++];
                if (sum == k) {
                    total++;
                }
            }
        }
        return total;
    }
}
