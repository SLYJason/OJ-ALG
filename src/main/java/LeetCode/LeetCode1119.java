package LeetCode;

public class LeetCode1119 {
    public String removeVowels(String S) {
        for (int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                S = S.substring(0, i) + S.substring(i+1);
                i -= 1;
            }
        }
        return S;
    }
}
