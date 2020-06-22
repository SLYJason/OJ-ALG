package LeetCode.BitManipulation;

public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num : nums) {
            diff ^= num;
        }
        diff &= (-diff); // x & (-x) to get rightmost 1-bit
        int[] ans = new int[2];
        for(int num : nums) {
            if((num & diff) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
