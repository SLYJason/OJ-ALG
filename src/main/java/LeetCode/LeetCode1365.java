package LeetCode;

public class LeetCode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counter = new int[101];
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            counter[nums[i]]++;
        }
        for(int i=1; i<counter.length; i++) {
            counter[i] += counter[i-1];
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = counter[nums[i]-1];
            }
        }
        return ans;
    }
}
