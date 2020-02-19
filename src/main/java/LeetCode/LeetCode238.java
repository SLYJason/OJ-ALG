package LeetCode;

public class LeetCode238 {
    // Solution 1: initial thoughts
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] productExceptSelf(int[] nums) {
        int[] Left = new int[nums.length];
        int[] Right = new int[nums.length];
        int[] Output = new int[nums.length];
        Left[0] = 1;
        Right[nums.length-1] = 1;
        for(int i=1; i<nums.length; i++) {
            Left[i] = Left[i-1] * nums[i-1];
        }
        for(int i=nums.length-2; i>-1; i--) {
            Right[i] = Right[i+1] * nums[i+1];
        }
        for(int i=0; i<nums.length; i++) {
            Output[i] = Left[i] * Right[i];
        }
        return Output;
    }

    // Solution 2: Follow up, the output array does not count as extra space for the purpose of space complexity analysis
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int[] productExceptSel2(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i=1; i<nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        int right = 1;
        for(int i=nums.length-1; i>=0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
