package LeetCode.LC_1_200.LC29;

/**
 * Solution 3: bit manipulation - use long.
 */
public class Solution_3 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1; // XOR trick.
        long dvd = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        long quotient = 0;
        while(dvd >= div) {
            long tmp = div, count = 1;
            while(dvd - tmp >= tmp) {
                count <<= 1;
                tmp <<= 1;
            }
            quotient += count;
            dvd -= tmp;
        }
        return sign * (int)quotient;
    }
}
