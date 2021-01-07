package LeetCode.LC_201_400.LC315;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * Solution 1: binary indexed tree.
 */
public class Solution_1 {
    int[] sorted;
    Map<Integer, Integer> ranks;
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        discretization(nums);

        BIT bit = new BIT(ranks.size());
        for(int i=n-1; i>=0; i--) {
            int rank = ranks.get(nums[i]);
            int count = bit.queryTree(rank - 1);
            res.add(count);
            bit.updateTree(rank, 1);
        }
        Collections.reverse(res);
        return res;
    }

    private void discretization(int[] nums) {
        int n = nums.length;
        sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        // fill ranks: K -> num, V -> rank.
        ranks = new HashMap<>();
        int rank = 1;
        for(int i=0; i<n; i++) {
            if(i == 0 || sorted[i-1] != sorted[i]) {
                ranks.put(sorted[i], rank++);
            }
        }
    }

    class BIT {
        int[] BIT;
        public BIT(int n) {
            BIT = new int[n + 1];
        }

        // update BIT: only add the difference between new value and old value.
        private void updateTree(int i, int delta) {
            while(i < BIT.length) {
                BIT[i] += delta;
                i += LSB(i);
            }
        }

        // query BIT: get prefix sum with length i.
        private int queryTree(int i) {
            int sum = 0;
            while(i > 0) {
                sum += BIT[i];
                i -= LSB(i);
            }
            return sum;
        }

        // get the least significant bit.
        private int LSB(int x) {
            return x & (-x);
        }
    }
}
