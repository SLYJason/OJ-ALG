package LeetCode.LC_1_200.LC31;

/**
 * Solution: math.
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1, n = nums.length - 1;
        // 1. find index i from the end that breaks descending order: nums[i-1] >= nums[i].
        while(i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }
        if(i == 0) {
            // if no such i exist, reverse nums.
            reverse(nums, 0, n);
            return;
        }
        // 2. Find the rightmost index j greater than index i-1 such that nums[i-1] < nums[j].
        int j = nums.length-1;
        while(j >= 0 && nums[i-1] >= nums[j]) {
            j--;
        }
        // 3. swap nums[j] and nums[i-1].
        swap(nums, i-1, j);
        // 4. reverse the rest element from index i.
        reverse(nums, i, n);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
