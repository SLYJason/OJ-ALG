package LeetCode.LC_1_200.LC55;

public class Solution_3 {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int lastPos = nums.length-1;
        for(int pos=nums.length-1; pos>=0; pos--) {
            if(nums[pos] + pos >= lastPos) {
                lastPos = pos;
            }
        }
        return lastPos == 0;
    }
}
