package LeetCode.LC_401_600.LC504;

/**
 * Solution 1: iterative.
 */
public class Solution_1 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        int n = Math.abs(num);
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int reminder = n % 7;
            n = n / 7;
            sb.append(reminder);
        }

        sb = sb.reverse();
        return num > 0 ? sb.toString() : sb.insert(0, "-").toString();
    }
}
