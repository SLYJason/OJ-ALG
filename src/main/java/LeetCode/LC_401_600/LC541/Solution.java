package LeetCode.LC_401_600.LC541;

/**
 * Solution: two pointers.
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] S = s.toCharArray();
        for(int i=0; i<s.length(); i += 2 * k) {
            int left = i, right = Math.min(i + k - 1, s.length()-1);
            while(left < right) {
                char tmp = S[left];
                S[left] = S[right];
                S[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(S);
    }
}
