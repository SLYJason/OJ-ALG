package LeetCode.LC_1_200.LC18;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: K sum.
 */
public class Solution_2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return new ArrayList();
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        kSum(nums, 0, 4, target, new ArrayList<>(), res);
        return res;
    }

    public List<List<Integer>> kSum(int[] nums, int start, int ksum, int target, List<Integer> list, List<List<Integer>> res) {
        if(start == nums.length) return res;
        if(ksum == 2) {
            int left = start, right = nums.length-1;
            while(left < right) {
                if(nums[left] + nums[right] == target) {
                    res.add(new ArrayList<>(list));
                    res.get(res.size()-1).addAll(Arrays.asList(nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++; // remove duplicates.
                    while(left < right && nums[right] == nums[right-1]) right--; // remove duplicates.
                    left++;
                    right--;
                } else if(nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for(int i=start; i<nums.length-ksum+1; i++) {
                if(i > start && nums[i-1] == nums[i]) continue; // remove duplicates.
                list.add(nums[i]);
                kSum(nums, i+1, ksum-1, target-nums[i], list, res);
                list.remove(list.size()-1);
            }
        }
        return res;
    }
}
