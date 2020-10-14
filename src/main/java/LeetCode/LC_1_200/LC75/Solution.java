package LeetCode.LC_1_200.LC75;

public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length-1, index = 0;
        while(index <= p2) {
            if(nums[index] == 0) {
                swap(nums, p0++, index++);
            } else if(nums[index] == 2) {
                swap(nums, p2--, index);
            } else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
