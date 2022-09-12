package LeetCode.LC_2201_2400.LC2239;

public class Solution {
    public int findClosestNumber(int[] nums) {
        int result = Integer.MAX_VALUE;
        for(int n : nums) {
            if (Math.abs(n) < Math.abs(result) || n == Math.abs(result)) {
                result = n;
            }
        }
        return result;
    }
}
