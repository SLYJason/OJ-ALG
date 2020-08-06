package LeetCode.Array;

import java.util.List;
import java.util.LinkedList;

public class LeetCode442 {
    /**
     * Optimal solution: given the truth 1 ≤ a[i] ≤ n (n = size of array).
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList();
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0) {
                ans.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        return ans;
    }
}
