package LeetCode.String;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class LeetCode824 {
    /**
     * Solution 1: intuitive thoughts, runs faster.
     */
    public String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0, j = 1;
        String aEnd = "a";
        StringBuilder sb = new StringBuilder();
        while(j < S.length()) {
            while(j < S.length() && S.charAt(j) != ' ') {
                j++;
            }
            String str = S.substring(i, j);
            if(vowels.contains(str.charAt(0))) {
                sb.append(str);
                sb.append("ma");
            } else {
                sb.append(str.substring(1));
                sb.append(str.substring(0, 1));
                sb.append("ma");
            }
            sb.append(aEnd);
            sb.append(" ");
            aEnd += "a";
            while(j < S.length() && S.charAt(j) == ' ') {
                j++;
            }
            i = j;
        }
        return sb.toString().trim();
    }

    /**
     * Solution 2: concise solution.
     */
    public String toGoatLatin2(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String aEnd = "a";
        StringBuilder res = new StringBuilder();
        for(String str : S.split("\\s+")) {
            char ch = str.charAt(0);
            String word = vowels.contains(ch) ? str : str.substring(1) + str.charAt(0);
            res.append(word + "ma" + aEnd + " ");
            aEnd += "a";
        }
        return res.toString().trim();
    }
}
