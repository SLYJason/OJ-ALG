package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode409 {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<Character>();
        int length = 0;
        for(char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                length++;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.isEmpty() ? length*2 : length*2+1;
    }

    // Greedy approach
    /*public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int length = 0;
        for (int c : count) {
            length += c / 2 * 2;
            if (length % 2 == 0 && c % 2 == 1)
                length++;
        }
        return length;
    }*/
}

