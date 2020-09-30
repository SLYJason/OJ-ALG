package LeetCode.LC1047;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public String removeDuplicates(String S) {
        if(S.length() < 2) return S;
        for(int i=1; i<S.length(); i++) {
            if(S.charAt(i) == S.charAt(i-1)) {
                S = S.substring(0, i-1) + S.substring(i+1);
            }
        }
        return S;
    }
}
