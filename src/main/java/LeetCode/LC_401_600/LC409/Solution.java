package LeetCode.LC_401_600.LC409;

/**
 * Solution: Greedy.
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[64];
        int ans = 0;
        for (char c: s.toCharArray())
            count[c-'A']++;
        for (int c: count) {
            ans += c / 2 * 2;
            if (ans % 2 == 0 && c % 2 == 1)
                ans++;
        }
        return ans;
    }
}

