package LeetCode.LC_201_400.LC345;

/**
 * Solution: two pointers.
 */
public class Solution {
    public String reverseVowels(String s) {
        if(s.length() <= 1) return s;
        int i=0, j=s.length()-1;
        char[] S = s.toCharArray();
        while(i < j) {
            while(i < j && !isVowels(S[i])) i++;
            while(i < j && !isVowels(S[j])) j--;
            char tmp = S[i];
            S[i] = S[j];
            S[j] = tmp;
            i++;
            j--;
        }
        return new String(S);
    }

    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
