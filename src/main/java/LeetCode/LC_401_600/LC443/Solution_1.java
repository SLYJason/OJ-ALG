package LeetCode.LC_401_600.LC443;

/**
 * Solution 1: brute-force, intuitive thoughts.
 * Time Complexity: O(N).
 * Space Complexity: O(N).
 */
public class Solution_1 {
    public int compress(char[] chars) {
        if(chars.length <= 1) return chars.length;
        String s = "";
        int count = 1;
        for(int i=1; i<chars.length; i++) {
            if(chars[i-1] == chars[i]) {
                count++;
            } else {
                s += count == 1 ? chars[i-1] : chars[i-1] + "" + count;
                count = 1;
            }
        }
        s += count == 1 ? chars[chars.length-1] : chars[chars.length-1] + "" + count;
        for(int i=0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}
