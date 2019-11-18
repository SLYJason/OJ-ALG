package LeetCode;

public class LeetCode724 {
    public int pivotIndex(int[] nums) {
        int pivot = -1, sum = 0, leftSum = 0;
        for(int i : nums) {
            sum += i;
        }
        for(int i=0; i<nums.length; i++) {
            leftSum = i > 0 ? leftSum + nums[i-1] : leftSum ;
            if (sum - nums[i] - leftSum == leftSum) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }
}
