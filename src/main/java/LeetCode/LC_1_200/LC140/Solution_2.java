package LeetCode.LC_1_200.LC140;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: memorization
 * Time Complexity: O(2^n)
 * Space Complexity: O(2^n)
 */
public class Solution_2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap();
        return wb(s, new HashSet(wordDict), memo);
    }

    public List<String> wb(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        // word break solutions for string s
        List<String> ans = new LinkedList();
        if(wordDict.contains(s)) {
            ans.add(s);
        }
        for(int i=0; i<=s.length(); i++) {
            String left = s.substring(0, i); // wordDict check
            String right = s.substring(i); // recursive check
            if(wordDict.contains(left)) {
                List<String> right_ans = append(wb(right, wordDict, memo), left);
                ans.addAll(right_ans);
            }
        }
        memo.put(s, ans);
        return memo.get(s);
    }

    private List<String> append(List<String> list, String prefix) {
        List<String> res = new LinkedList();
        for(String str : list) {
            res.add(prefix + " " + str);
        }
        return res;
    }
}
