package LeetCode;

public class LeetCode198 {
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for(int n:nums) {
            int temp = currMax;
            currMax = Math.max(prevMax+n, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
