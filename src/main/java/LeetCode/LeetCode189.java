package LeetCode;

public class LeetCode189 {
    // O(n) time complexity, O(n) space complexity
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
//    O(n) time complexity, O(n) space complexity
//    public void rotate2(int[] nums, int k) {
//        k = k % nums.length;
//        int[] rotated = new int[nums.length];
//        System.arraycopy(nums, nums.length-k, rotated, 0, k);
//        System.arraycopy(nums, 0, rotated, k, nums.length-k);
//        System.arraycopy(rotated, 0, nums, 0, nums.length);
//    }
}
