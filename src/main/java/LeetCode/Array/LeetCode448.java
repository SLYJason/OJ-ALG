package LeetCode.Array;

import java.util.List;
import java.util.LinkedList;

public class LeetCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList();
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for(int i=1; i<=nums.length; i++) {
            if(nums[i-1] > 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
