package LeetCode.LC_1_200.LC34;

/**
 * Solution: binary search.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int first = findFirst(nums, target);
        if(first == -1) return new int[]{-1, -1};
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    public int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2; // get lower bound.
            if(nums[mid] == target) {
                right = mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1; // check if we find target index.
    }

    public int findLast(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2; // get upper bound.
            if(nums[mid] == target) {
                left = mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
