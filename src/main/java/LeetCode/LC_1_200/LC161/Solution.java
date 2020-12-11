package LeetCode.LC_1_200.LC161;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len_s = s.length(), len_t = t.length();
        for(int i=0; i<Math.min(len_s, len_t); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(len_s == len_t) {
                    return s.substring(i+1).equals(t.substring(i+1)); // replace char from s.
                } else if(len_s < len_t) {
                    return s.substring(i).equals(t.substring(i+1)); // add char to s.
                } else {
                    return s.substring(i+1).equals(t.substring(i)); // delete char from s.
                }
            }
        }
        return Math.abs(len_s - len_t) == 1; // all previous chars are same, just delete char to compare. Ex. "abc" and "abcd"
    }
}
