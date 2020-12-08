package LeetCode.LC_1201_1400.LC1239;

import java.util.List;

/**
 * Solution 1: backtrack + dfs.
 */
class Solution_1 {
    int maxLength = 0;
    public int maxLength(List<String> arr) {
        concat(0, 0, arr, new int[128]);
        return maxLength;
    }

    private void concat(int start, int len, List<String> arr, int[] memo) {
        if(start == arr.size()) return;
        for(int i=start; i<arr.size(); i++) {
            char[] cur = arr.get(i).toCharArray();
            boolean dup = false;
            for(char ch : cur) {
                if(memo[ch] > 0) dup = true;
                memo[ch]++;
            }
            if(!dup) {
                len += arr.get(i).length();
                maxLength = Math.max(maxLength, len);
            }

            concat(i+1, len, arr, memo);

            for(char ch : cur) memo[ch]--; // backtrack, remove previous string characters from memo.
            if(!dup) len -= arr.get(i).length(); // backtrack, subtract previous string length.
        }
    }
}