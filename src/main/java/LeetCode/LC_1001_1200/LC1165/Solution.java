package LeetCode.LC_1001_1200.LC1165;

/**
 * Solution: map.
 */
public class Solution {
    public int calculateTime(String keyboard, String word) {
        char[] k = keyboard.toCharArray();
        int[] map = new int[26];
        for(int i=0; i<k.length; i++) {
            map[k[i] - 'a'] = i;
        }
        int time = 0, prev = 0;
        char[] w = word.toCharArray();
        for(int i=0; i<w.length; i++) {
            time += Math.abs(map[w[i] - 'a'] - prev);
            prev = map[w[i] - 'a'];
        }
        return time;
    }
}
