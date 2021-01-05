package LeetCode.LC_201_400.LC267;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution: backtrack.
 */
public class Solution {
    public List<String> generatePalindromes(String s) {
        if(s.length() == 0) return new ArrayList<>(); // base case 1.
        if(s.length() == 1) return Arrays.asList(s); // base case 2.

        int[] count = new int[128];
        int odds = 0, n = s.length();
        for(char ch : s.toCharArray()) {
            count[ch]++;
            odds = count[ch] % 2 == 0 ? odds - 1 : odds + 1;
        }
        if(odds > 1) return new ArrayList<>(); // cannot form palindrome.

        // find the center character.
        int center = -1;
        for(int i = 0; i < 128; i++) if(count[i] % 2 != 0) center = i;
        char[] S = new char[s.length()];
        if(center != -1) {
            S[n / 2] = (char)center;
            count[center]--;
        }
        // permutate all the palindromes.
        List<String> res = new ArrayList<>();
        permutate(count, S, 0, n - 1, res);
        return res;
    }

    private void permutate(int[] count, char[] S, int left, int right, List<String> res) {
        if(left >= right) {
            res.add(new String(S));
            return;
        }
        for(int i=0; i<count.length; i++) {
            if(count[i] > 1) {
                S[left] = S[right] = (char)i;
                count[i] -= 2;
                permutate(count, S, left + 1, right - 1, res);
                count[i] += 2;
            }
        }
    }
}
