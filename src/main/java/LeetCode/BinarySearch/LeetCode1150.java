package LeetCode.BinarySearch;

public class LeetCode1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int firstOccur = search(nums, target);
        int secondIndex = firstOccur + nums.length/2;
        if(secondIndex < nums.length && nums[secondIndex] == target) {
            return true;
        }
        return false;
    }

    private int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
