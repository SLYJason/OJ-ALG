package LeetCode.LC_201_400.LC245;

/**
 * Solution: one-pass.
 */
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, min = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(word1)) idx1 = i;
            if(words[i].equals(word2)) {
                if(same) idx1 = idx2;
                idx2 = i;
            }
            if(idx1 != -1 && idx2 != -1) min = Math.min(min, Math.abs(idx1 - idx2));
        }
        return min;
    }
}
