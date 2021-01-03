package LeetCode.LC_401_600.LC526;

/**
 * Solution: backtrack.
 */
public class Solution {
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = i+1;
        return permutate(nums, 0, new boolean[n]);
    }

    private int permutate(int[] nums, int size, boolean[] used) {
        if(size == nums.length) return 1;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int index = size + 1;
            if(!used[i] && (nums[i] % index == 0 || index % nums[i] == 0)) {
                used[i] = true;
                count += permutate(nums, size + 1, used);
                used[i] = false;
            }
        }
        return count;
    }
}
