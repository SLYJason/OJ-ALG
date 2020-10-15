package LeetCode.LC_1_200.LC80;

/**
 * Solution 2: optimal solution.
 */
public class Solution_2 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2]) nums[i++] = n;
        return i;
    }
}
