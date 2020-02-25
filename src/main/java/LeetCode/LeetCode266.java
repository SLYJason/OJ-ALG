package LeetCode;

import java.util.Set;
import java.util.HashSet;

public class LeetCode266 {
    // Solution 1: using array, single pass
    public boolean canPermutePalindrome(String s) {
        int[] array = new int[128];
        int count = 0;
        for(char ch:s.toCharArray()) {
            array[ch]++;
            if(array[ch] % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }

    // Solution 2: using Set
    public boolean canPermutePalindrome2(String s) {
        Set<Character> set = new HashSet();
        for(char ch:s.toCharArray()) {
            if(set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size() > 1 ? false : true;
    }
}
