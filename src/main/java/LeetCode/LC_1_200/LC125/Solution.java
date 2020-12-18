package LeetCode.LC_1_200.LC125;

public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return true;
        int i=0, j=s.length()-1;
        while(i<j) {
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) return false;
            i++;
            j--;
        }
        return true;
    }
}
