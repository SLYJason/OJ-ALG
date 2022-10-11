package LeetCode.LC_1_200.LC28;

/**
 * Solution 2: KMP.
 */
public class Solution_2 {
    public int strStr(String haystack, String needle) {
        if (haystack == null && needle == null) return 0;
        if (haystack == null) return -1;
        if (needle == null) return 0;

        int[] lps = computerLps(needle);

        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // find the first match.
                }
            } else {
                if (j - 1 >= 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }


    // get KMP longest proper prefix/suffix array
    public int[] computerLps(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = ++j;
            }
        }
        return lps;
    }
}
