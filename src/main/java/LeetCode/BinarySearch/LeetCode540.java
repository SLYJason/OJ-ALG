package LeetCode.BinarySearch;

public class LeetCode540 {
    // Solution: Binary search at even indexes.
    // Algorithm: the single element divided the array into left-sub array and right-sub array.
    // For left-sub, the pair follows even-odd index patten; For right-sub, the pair follows odd-even index pattern.
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 != 0) mid--;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
