package LeetCode.LC_1601_1800.LC1754;

/**
 * Solution: greedy.
 */
public class Solution {
    public String largestMerge(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if(n1 == 0 || n2 == 0) return word1 + word2;
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while(i < n1 && j < n2) {
            String sub1 = word1.substring(i);
            String sub2 = word2.substring(j);
            merge.append(sub1.compareTo(sub2) >= 0 ? word1.charAt(i++) : word2.charAt(j++));
        }
        merge.append(word1.substring(i));
        merge.append(word2.substring(j));
        return merge.toString();
    }
}
