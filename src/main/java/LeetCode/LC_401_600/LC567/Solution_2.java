package LeetCode.LC_401_600.LC567;

/**
 * Solution 2: sliding window - changed window size.
 */
public class Solution_2 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1_count = new int[128];
        for(char ch : s1.toCharArray()) s1_count[ch]++;

        int[] window = new int[128];
        int distance = 0;
        for(int i=0, j=0; j<s2.length(); j++) {
            char ch = s2.charAt(j);
            window[ch]++;
            if(window[ch] <= s1_count[ch]) distance++;

            // contract the window
            while(distance == s1.length()) {
                if(j-i+1 == s1.length()) return true;
                if(window[s2.charAt(i)] == s1_count[s2.charAt(i)]) distance--;
                window[s2.charAt(i)]--;
                i++;
            }
        }
        return false;
    }
}
