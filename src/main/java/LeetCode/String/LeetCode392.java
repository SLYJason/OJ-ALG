package LeetCode.String;

public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int i=0;
        for(int j=0; j<t.length(); j++) {
            if(i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i >= s.length();
    }
}
