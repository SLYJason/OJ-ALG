package LeetCode.LC_1_200.LC29;

public class Solution_1 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // corner case: -2147483648 / -1.

        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0); // positive results or not.
        dividend = -Math.abs(dividend); // convert to negative value.
        divisor = -Math.abs(divisor); // convert to negative value.
        int quotient = 0;
        while(dividend <= divisor) {
            dividend -= divisor;
            quotient++;
        }
        return positive ? quotient : -quotient;
    }
}
