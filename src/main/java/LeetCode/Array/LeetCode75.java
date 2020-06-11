package LeetCode.Array;

public class LeetCode75 {
    public void sortColors(int[] nums) {
        int curr = 0, p0 = 0, p2 = nums.length-1;
        while(curr <= p2) {
            if(nums[curr] == 0) {
                swap(nums, curr, p0);
                p0++;
            } else if(nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
                curr--;
            }
            curr++;
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
