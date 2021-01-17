package LeetCode.LC_201_400.LC215;

/**
 * Solution: quick select.
 */
public class Solution_2 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right) {
            int pos = quickSelect(nums, left, right);
            if(k == n - pos) return nums[pos];
            if(k > n - pos) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
        return -1;
    }

    private int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1, j = left + 1;
        while(j <= right) {
            if(nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, left, --i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
