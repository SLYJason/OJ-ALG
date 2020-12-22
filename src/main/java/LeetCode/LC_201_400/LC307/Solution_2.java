package LeetCode.LC_201_400.LC307;

/**
 * Solution 2: binary indexed tree.
 */
public class Solution_2 {
    class NumArray {
        int[] nums;
        int[] BIT;
        public NumArray(int[] nums) {
            if(nums.length != 0) {
                this.nums = nums;
                this.BIT = new int[nums.length+1];
                for(int i=0; i<nums.length; i++) {
                    updateTree(i+1, nums[i]);
                }
            }
        }

        public void update(int i, int val) {
            updateTree(i + 1, val - nums[i]);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return queryTree(j+1) - queryTree(i);
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
