package LeetCode.LC_801_1000.LC821;

/**
 * Solution: two-way pass.
 */
public class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int prev = -n;
        int[] answers = new int[n];
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == c) prev = i;
            answers[i] = i - prev;
        }
        prev = 2 * n;
        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i) == c) prev = i;
            answers[i] = Math.min(answers[i], prev - i);
        }
        return answers;
    }
}
