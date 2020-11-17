package LeetCode.LC_201_400.LC336;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words.length < 2) return new ArrayList();
        List<List<Integer>> res = new ArrayList();
        Map<String, Integer> map = new HashMap(); // K: word[i], V: index of word[i].
        for(int i=0; i<words.length; i++) map.put(words[i], i);

        for(int i=0; i<words.length; i++) {
            // Case 1: word is half of the palindrome.
            String reversed = new StringBuilder(words[i]).reverse().toString();
            if(map.containsKey(reversed) && map.get(reversed) != i) {
                res.add(Arrays.asList(i, map.get(reversed)));
            }

            // Case 2: get palindrome suffix
            for(String suffix : palindromeSuffixes(words[i])) {
                String rev = new StringBuilder(suffix).reverse().toString();
                if(map.containsKey(rev) && map.get(rev) != i) {
                    res.add(Arrays.asList(map.get(rev), i));
                }
            }

            // Case 3: get palindrome prefix
            for(String prefix : palindromePrefixes(words[i])) {
                String rev = new StringBuilder(prefix).reverse().toString();
                if(map.containsKey(rev) && map.get(rev) != i) {
                    res.add(Arrays.asList(i, map.get(rev)));
                }
            }
        }
        return res;
    }
    // if substring[0, i] is palindrome, then return its all suffixes substring[i+1].
    private List<String> palindromeSuffixes(String s) {
        List<String> suffixes = new ArrayList();
        for(int i=0; i<s.length(); i++) {
            if(isPalindrome(s, 0, i)) {
                suffixes.add(s.substring(i+1));
            }
        }
        return suffixes;
    }

    // if substring[i] is palindrome, then return its all prefixes substring[0, i-1];
    private List<String> palindromePrefixes(String s) {
        List<String> prefixes = new ArrayList();
        for(int i=0; i<s.length(); i++) {
            if(isPalindrome(s, i, s.length()-1)) {
                prefixes.add(s.substring(0, i));
            }
        }
        return prefixes;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
