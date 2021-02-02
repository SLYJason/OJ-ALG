package LeetCode.LC_1_200.LC191;

/**
 * Solution 1: using mask.
 */
public class Solution_1 {
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        for(int i=0; i<32; i++) {
            if((n & mask) != 0) count++;
            mask = mask << 1;
        }
        return count;
    }
}
