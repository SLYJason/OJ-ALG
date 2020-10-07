package LeetCode.LC_1001_1200.LC1143;

import java.util.Arrays;

/**
 * Solution 1: recursion with memorization, top-down approach.
 */
public class Solution_1 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.equals(text2)) return text1.length();
        // memo[i][j]: the longest common substring of text1 substring [0, i) and text2 substring [0, j).
        int[][] memo = new int[text1.length()+1][text2.length()+1];
        for(int[] arr : memo) Arrays.fill(arr, -1); // initialization.
        lcs(text1, text2, text1.length(), text2.length(), memo);
        return memo[text1.length()][text2.length()];
    }

    private int lcs(String t1, String t2, int l1, int l2, int[][] memo) {
        if(l1 == 0 || l2 == 0) {
            memo[l1][l2] = 0;
            return 0;
        }
        if(memo[l1][l2] != -1) return memo[l1][l2];
        int max = 0;
        char ch1 = t1.charAt(l1-1);
        char ch2 = t2.charAt(l2-1);
        if(ch1 == ch2) {
            max = 1 + lcs(t1, t2, l1-1, l2-1, memo);
        } else {
            int len1 = lcs(t1, t2, l1-1, l2, memo);
            int len2 = lcs(t1, t2, l1, l2-1, memo);
            max = Math.max(len1, len2);
        }
        memo[l1][l2] = max;
        return max;
    }
}
