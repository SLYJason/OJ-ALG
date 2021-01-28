package LeetCode.LC_1601_1800.LC1680;

/**
 * Solution 2: bitwise manipulation.
 */
public class Solution_2 {
    public int concatenatedBinary(int n) {
        int mod = 1_000_000_007;
        int length = 0; // binary representation length of ith number.
        long res = 0;
        for(int i=1; i<=n; i++) {
            if((i & (i-1)) == 0) {
                length++; // ith number is power of 2, increase current length.
            }
            res = ((res << length) | i) % mod; // shift result left by length, then use | (OR) to add current number.
        }
        return (int)res;
    }
}
