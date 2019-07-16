package LeetCode;


public class LeetCode33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int minIndex = findMinIndex(nums);
        if (target == nums[minIndex]) return minIndex;
        int start = target <= nums[nums.length-1] ? minIndex : 0;
        int end = target <= nums[nums.length-1] ? nums.length-1 : minIndex;

        while(start <= end) {
            int mid = start + (end-start)/2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int findMinIndex(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
