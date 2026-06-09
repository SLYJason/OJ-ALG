package LeetCode.LC_1601_1800.LC1768;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, n1 = word1.length(), n2 = word2.length();
        StringBuilder sb = new StringBuilder();
        while (i < n1 || i < n2) {
            if (i < n1) sb.append(word1.charAt(i));
            if (i < n2) sb.append(word2.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
