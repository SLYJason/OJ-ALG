package LeetCode.LC_201_400.LC214;

public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        int len = s.length();
        for(int i=0; i<len; i++) {
            if(s.substring(0, len-i).equals(reverse.substring(i))) { // by compare s with reverse, we can find the longest palindrome from index 0 of s.
                return reverse.substring(0, i) + s;
            }
        }
        return "";
    }
}
