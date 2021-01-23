package LeetCode.LC_1_200.LC161;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() > t.length()) return isOneEditDistance(t, s);
        if(s.equals(t) || s.length() + 1 < t.length()) return false; // base case.
        int i = 0;
        while(i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) i++;
        return s.substring(i).equals(t.substring(i+1)) // insert
                || s.substring(i+1).equals(t.substring(i+1)); // replace
    }
}
