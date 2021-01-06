package LeetCode.LC_1_200.LC68;

import java.util.List;
import java.util.LinkedList;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int i = 0, n = words.length;
        while(i < words.length) {
            int j = i, length = words[i].length();
            while(j + 1 < words.length && length + words[j + 1].length() + (j + 1 - i) <= maxWidth) {
                length += words[j + 1].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            if(j == n - 1) { // Case 1: last line.
                while(i <= j) {
                    sb.append(words[i++]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1); // remove extra space in last word.
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else if(j - i == 0) { // Case 2: only one word in a line.
                sb.append(words[i]).append(" ");
                sb.deleteCharAt(sb.length() - 1); // remove extra space in last word.
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else { // Case 3: regular justify.
                int spaces = maxWidth - length;
                int space = spaces / (j - i);
                int extra = spaces % (j - i);
                while(i < j) {
                    sb.append(words[i++]);
                    if(extra-- > 0) sb.append(" "); // fill extra space.
                    for(int k=0; k<space; k++) sb.append(" "); // fill space.
                }
                sb.append(words[i]); // append the last word.
            }
            i = j + 1;
            res.add(sb.toString());
        }
        return res;
    }
}
