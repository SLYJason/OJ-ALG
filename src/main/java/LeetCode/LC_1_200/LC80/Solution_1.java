package LeetCode.LC_1_200.LC80;

/**
 * Solution 2: using two-pointers.
 */
public class Solution_1 {
    public int removeDuplicates(int[] nums) {
        int i=1, j=1, count=1;
        while(j < nums.length) {
            if(nums[j] == nums[j-1]) {
                count++;
            } else {
                count=1;
            }
            if(count <= 2) nums[i++] = nums[j];
            j++;
        }
        return i;
    }
}
