package LeetCode.LC_201_400.LC384;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/**
 * Solution 1: brute force.
 * Time Complexity: O(N^2), comes from list.remove().
 * Space Complexity: O(N).
 */
public class Solution_1 {
    int[] nums;
    List<Integer> cache;
    Random random;
    public Solution_1(int[] nums) {
        this.nums = nums;
        this.cache = new ArrayList();
        for(int i=0; i<nums.length; i++) cache.add(nums[i]);
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        cache.clear();
        for(int i=0; i<nums.length; i++) cache.add(nums[i]);
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[nums.length];
        for(int i = 0; i<nums.length && !cache.isEmpty(); i++) {
            int num = cache.get(random.nextInt(cache.size()));
            res[i] = num;
            cache.remove((Integer)num);

        }
        // refill the cache.
        for(int i=0; i<nums.length; i++) cache.add(nums[i]);
        return res;
    }
}
