package LeetCode.LC_1601_1800.LC1662;

/**
 * Solution: 4 pointers.
 */
public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0, w2 = 0, i1 = 0, i2 = 0;
        while(w1 < word1.length && w2 < word2.length) {
            String s1 = word1[w1], s2 = word2[w2];
            while(i1 < s1.length() && i2 < s2.length()) {
                if(s1.charAt(i1) != s2.charAt(i2)) return false;
                i1++;
                i2++;
            }
            if(i1 == s1.length()) {
                w1++;
                i1 = 0;
            }
            if(i2 == s2.length()) {
                w2++;
                i2 = 0;
            }
        }
        return w1 == word1.length && w2 == word2.length;
    }
}
