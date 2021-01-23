package LeetCode.LC_1601_1800.LC1657;

import java.util.Arrays;

/**
 * Solution: HashMap.
 */
public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false; // rule 1: same length.
        int[] f1 = new int[128], f2 = new int[128]; // rule 2: same char set.
        int[] count1 = new int[128], count2 = new int[128]; // rule 3: same sorted char frequencies.
        for(int ch : word1.toCharArray()) {
            count1[ch]++;
            f1[ch] = 1;
        }
        for(int ch : word2.toCharArray()) {
            count2[ch]++;
            f2[ch] = 1;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2) && Arrays.equals(f1, f2);
    }
}
