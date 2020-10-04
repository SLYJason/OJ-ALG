package LeetCode.LC_201_400.LC392;

public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int i=0, j=0;
        while(i < s.length() && j < t.length()) {
            char sc = s.charAt(i);
            char tc = t.charAt(j);
            if(sc == tc) i++;
            j++;
        }
        return i == s.length();
    }
}
