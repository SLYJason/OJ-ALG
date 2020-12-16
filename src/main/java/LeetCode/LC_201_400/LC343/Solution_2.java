package LeetCode.LC_201_400.LC343;

/**
 * Solution: Math.
 */
public class Solution_2 {
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        int num_3 = n / 3, reminder = n % 3;
        if(reminder == 0) return (int)Math.pow(3, num_3); // reminder is 0.
        if(reminder == 1) return (int)Math.pow(3, num_3 - 1) * 4; // reminder is 1.
        return (int)Math.pow(3, num_3) * reminder; // reminder is 2.
    }
}
