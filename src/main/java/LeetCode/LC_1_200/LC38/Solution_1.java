package LeetCode.LC_1_200.LC38;

/**
 * Solution 1: recursive.
 */
public class Solution_1 {
    public String countAndSay(int n) {
        if (n == 1) return "1"; // base case.

        String s = countAndSay(n - 1);
        int i = 0;
        StringBuilder countAndSay = new StringBuilder();
        while (i < s.length()) {
            char ch = s.charAt(i);
            int j = i, count = 0;
            while (j < s.length() && ch == s.charAt(j)) {
                j++;
                count++;
            }
            i = j;
            countAndSay.append(count).append(ch);
        }
        return countAndSay.toString();
    }
}
