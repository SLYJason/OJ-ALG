package LeetCode.LC_201_400.LC266;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: HashSet single pass.
 */
public class Solution_2 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet();
        for(char ch:s.toCharArray()) {
            if(set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size() <= 1;
    }
}
