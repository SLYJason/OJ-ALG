package LeetCode.LC_1_200.LC55;

/**
 * Solution 1: backtrack + memo.
 */
public class Solution_1 {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        return reachEnd(0, nums, new boolean[nums.length]);
    }

    private boolean reachEnd(int pos, int[] nums, boolean[] cantJump) {
        if(pos == nums.length-1) return true;
        if(cantJump[pos]) return false;
        for(int step=1; step<=nums[pos]; step++) {
            if(reachEnd(pos + step, nums, cantJump)) return true;
        }
        cantJump[pos] = true;
        return false;
    }
}
