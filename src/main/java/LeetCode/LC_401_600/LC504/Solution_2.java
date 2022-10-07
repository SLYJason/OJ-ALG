package LeetCode.LC_401_600.LC504;

/**
 * Solution 2: recursive.
 */
public class Solution_2 {
    public String convertToBase7(int num) {
        if (num < 0) return "-" + convertToBase7(-num);
        if (num < 7) return String.valueOf(num);
        return convertToBase7(num / 7) + num % 7;
    }
}
