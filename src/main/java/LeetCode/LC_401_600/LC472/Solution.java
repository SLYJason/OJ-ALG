package LeetCode.LC_401_600.LC472;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Solution: dp.
 */
public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(Arrays.asList(words)); // convert to Set to speed up lookup.
        for (String word : words) {
            if (word.length() == 0) continue;
            dict.remove(word);
            if (wordBreak(word, dict)) ans.add(word);
            dict.add(word);
        }
        return ans;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        // dp[i] means the first i characters of s can be split
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // base case
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // need to break the loop immediately, otherwise causing TLE.
                }
            }
        }
        return dp[s.length()];
    }
}
