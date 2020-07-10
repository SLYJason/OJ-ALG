package LeetCode.BitManipulation;

public class LeetCode389 {
    /**
     * Solution 1: find the char code accumulation difference
     */
    public char findTheDifference(String s, String t) {
        char charCode = t.charAt(s.length());
        for(int i=0; i<s.length(); i++) {
            charCode -= s.charAt(i);
            charCode += t.charAt(i);
        }
        return (char)charCode;
    }

    /**
     * Solution 2: bit manipulation
     */
    public char findTheDifference2(String s, String t) {
        char diff = 0;
        for(char ch : s.toCharArray()) {
            diff ^= ch;
        }
        for(char ch : t.toCharArray()) {
            diff ^= ch;
        }
        return diff;
    }
}
