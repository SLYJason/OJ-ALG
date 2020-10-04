package LeetCode.LC_401_600.LC443;

/**
 * Solution 2: Two-Pointers.
 * Time Complexity: O(N).
 * Space Complexity: O(1).
 */
public class Solution_2 {
    public int compress(char[] chars) {
        int p1 = 0, p2 = 0;
        while(p2 < chars.length) {
            char currChar = chars[p2];
            int count = 0;
            while(p2 < chars.length && currChar == chars[p2]) {
                count++;
                p2++;
            }
            chars[p1++] = currChar;
            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[p1++] = ch;
                }
            }

        }
        return p1;
    }
}
