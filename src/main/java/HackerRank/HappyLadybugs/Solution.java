package HackerRank.HappyLadybugs;

public class Solution {
    static String happyLadybugs(String b) {
        if(b.length() == 0) return "NO"; // base case 1.
        if(b.length() == 1) return b.equals("_") ? "YES" : "NO"; // base case 2.
        int[] count = new int[26];
        boolean has_underscore = false;
        for(int i=0; i<b.length(); i++) {
            if(b.charAt(i) == '_') {
                has_underscore = true;
            } else {
                count[b.charAt(i) - 'A']++;
            }
        }
        if(!has_underscore) {
            if(b.charAt(0) != b.charAt(1) || b.charAt(b.length()-1) != b.charAt(b.length()-2)) return "NO"; // boundary check.
            for(int i=1; i<b.length()-1; i++) {
                if(b.charAt(i) != b.charAt(i-1) && b.charAt(i) != b.charAt(i+1)) return "NO";
            }
            return "YES";
        }
        for(int i=0; i<26; i++) {
            if(count[i] == 1) return "NO";
        }
        return "YES";
    }
}
