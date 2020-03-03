package LeetCode;

public class LeetCode153 {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) {
            return Integer.MIN_VALUE;
        }
        // array not rotated
        if(nums[nums.length-1] >= nums[0]) {
            return nums[0];
        }
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[0]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return nums[left];
    }
}
