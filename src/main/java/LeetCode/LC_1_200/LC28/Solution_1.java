package LeetCode.LC_1_200.LC28;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int strStr(String haystack, String needle) {
        if (haystack == null && needle == null) return 0;
        if (haystack == null) return -1;
        if (needle == null) return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                j++;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }
}
