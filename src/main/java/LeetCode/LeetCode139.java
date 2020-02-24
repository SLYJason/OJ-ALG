package LeetCode;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class LeetCode139 {
    // Reference: http://zxi.mytechroad.com/blog/leetcode/leetcode-139-word-break/
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap();
        return wordBreak(s, wordDict, memo);
    }

    private boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> memo) {
        // In memory, directly return
        if (memo.containsKey(s)) return memo.get(s);
        // Whole string is a word, memorize and return
        if (wordDict.contains(s)) {
            memo.put(s, true);
            return true;
        }
        for(int i=0; i<s.length(); i++) {
            String left = s.substring(0, i); // recursive check
            String right = s.substring(i); // wordDict check
            if(wordDict.contains(right) && wordBreak(left, wordDict, memo)) {
                memo.put(left, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
