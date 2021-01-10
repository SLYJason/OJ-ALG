package LeetCode.LC_1601_1800.LC1649;

class Solution {
    public int createSortedArray(int[] instructions) {
        int cost = 0, mod = (int)1e9 + 7;
        BIT bit = new BIT(100000);
        for(int i=0; i<instructions.length; i++) {
            int less = bit.queryTree(instructions[i] - 1);
            int more = i - bit.queryTree(instructions[i]);
            cost = (cost + Math.min(less, more)) % mod;
            bit.updateTree(instructions[i], 1);
        }
        return cost % mod;
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