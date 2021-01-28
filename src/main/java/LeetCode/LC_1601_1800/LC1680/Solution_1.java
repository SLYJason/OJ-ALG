package LeetCode.LC_1601_1800.LC1680;

/**
 * Solution 1: Change to Binary String.
 */
public class Solution_1 {
    public int concatenatedBinary(int n) {
        int res = 0, mod = 1_000_000_007;
        for(int i=1; i<=n; i++) {
            String binary = Integer.toBinaryString(i);
            for(int j=0; j<binary.length(); j++) {
                res = (res * 2 + (binary.charAt(j) - '0')) % mod;
            }
        }
        return res;
    }
}
