package LeetCode.LC_201_400.LC215;

public class Solution_2 {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length-1, index = -1;
        while(index != nums.length - k) {
            index = quickSelect(nums, start, end);
            if(index < nums.length - k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return nums[index];
    }

    private int quickSelect(int[] nums, int start, int end) {
        int i=start+1, j=start+1;
        int pivot = nums[start];
        while(j<=end) {
            if(nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, start, --i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
