package LeetCode.LC_1_200.LC44;

/**
 * Solution 2: Two Pointers.
 */
public class Solution_2 {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, n1 = s.length(), n2 = p.length();
        int lastWildCard = -1, sBacktrack = -1;
        while (i < n1) {
            if (j < n2 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) { // chars match.
                i++;
                j++;
            } else if (j < n2 && p.charAt(j) == '*') { // wildcard, so chars match - store index.
                lastWildCard = j++;
                sBacktrack = i;
            } else if (lastWildCard == -1) { // no match and no wildcard have been found.
                return false;
            } else { // backtrack - no match, but a previous wildcard was found.
                j = lastWildCard + 1;
                i = ++sBacktrack;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(Math.max(0, n2 - j)));
        return sb.toString().equals(p.substring(j));
    }
}
