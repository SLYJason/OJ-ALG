package LeetCode.BackTrack;

public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        // find index from the end that breaks descending order
        while(i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        if(i == 0) {
            // arrangement is not possible, return the lowest possible order
            reverse(nums, 0);
            return;
        }
        // find the rightmost index that nums[j] > nums[i-1]
        int j = nums.length-1;
        while(j >= 0 && nums[j] <= nums[i-1]) {
            j--;
        }
        // swap nums[j] and nums[i-1]
        swap(nums, i-1, j);
        // reverse the rest element from index i
        reverse(nums, i);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length-1;
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
