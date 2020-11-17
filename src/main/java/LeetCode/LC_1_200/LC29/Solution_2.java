package LeetCode.LC_1_200.LC29;

public class Solution_2 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = -Math.abs(dividend); // convert to negative value.
        divisor = -Math.abs(divisor); // convert to negative value.
        int quotient = 0;
        while(dividend <= divisor) {
            int temp = divisor, count = 1;
            while(dividend - temp <= temp) {
                temp = temp << 1;
                count = count << 1;
            }
            dividend -= temp;
            quotient += count;
        }
        return positive ? quotient : -quotient;
    }
}
