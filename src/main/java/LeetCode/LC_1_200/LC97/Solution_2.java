package LeetCode.LC_1_200.LC97;

/**
 * Solution 2: DFS + memorization.
 */
public class Solution_2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false; // base case.
        return isInterleave(0, 0, 0, s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), new boolean[s1.length()+1][s2.length()+1]);
    }

    // invalid[i][j]: s1 substring length i and s2 substring length j can not form s3 substring k.
    private boolean isInterleave(int i, int j, int k, char[] c1, char[] c2, char[] c3, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid = false;
        if(i < c1.length) valid = valid || c1[i] == c3[k] && isInterleave(i+1, j, k+1, c1, c2, c3, invalid);
        if(j < c2.length) valid = valid || c2[j] == c3[k] && isInterleave(i, j+1, k+1, c1, c2, c3, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
    }
}
