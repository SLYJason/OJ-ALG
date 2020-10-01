package LeetCode.LC1209;

/**
 * Solution 1: brute force, intuitive thoughts.
 */
public class Solution_1 {
    public String removeDuplicates(String s, int k) {
        if(s.length() < 2) return s;
        for(int i=0; i<s.length(); i++) {
            int j=i+1;
            while(j<s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
                if(j-i == k) break;
            }
            if(j-i == k) {
                s = s.substring(0, i) + s.substring(j);
                i=-1;
            }
        }
        return s;
    }
}
