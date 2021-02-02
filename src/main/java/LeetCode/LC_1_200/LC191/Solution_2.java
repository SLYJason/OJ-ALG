package LeetCode.LC_1_200.LC191;

/**
 * Solution 2: bit manipulation trick.
 */
public class Solution_2 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
