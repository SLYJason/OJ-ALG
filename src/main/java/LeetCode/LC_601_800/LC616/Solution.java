package LeetCode.LC_601_800.LC616;

/**
 * Solution: greedy.
 */
public class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        // step 1: mark the inside bold tag char as true in bold array.
        for (int i = 0, j = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    j = Math.max(j, i + word.length());
                }
            }
            bold[i] = j > i;
        }
        // step 2: build the result.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!bold[i]) {
                sb.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            sb.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        return sb.toString();
    }
}
