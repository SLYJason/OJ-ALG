package LeetCode.LC_1_200.LC38;

/**
 * Solution 2: iterative.
 */
public class Solution_2 {
    public String countAndSay(int n) {
        if (n == 1) return "1"; // base case.

        StringBuilder cur = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 0;
            while (j < cur.length()) {
                char ch = cur.charAt(j);
                int k = j, count = 0;
                while (k < cur.length() && ch == cur.charAt(k)) {
                    k++;
                    count++;
                }
                j = k;
                next.append(count).append(ch);
            }
            cur = next;
        }
        return cur.toString();
    }
}
