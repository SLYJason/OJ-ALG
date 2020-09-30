package LeetCode.LC1047;

/**
 * Solution 2: using StringBuilder as Stack.
 */
public class Solution_2 {
    public String removeDuplicates(String S) {
        if(S.length() < 2) return S;
        StringBuilder sb = new StringBuilder();
        for(char ch : S.toCharArray()) {
            int len = sb.length();
            if(len > 0 && sb.charAt(len-1) == ch) {
                sb.deleteCharAt(len-1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
