package LeetCode.LC_1201_1400.LC1249;

/**
 * Solution 2: two pass.
 */
public class Solution_2 {
    public String minRemoveToMakeValid(String s) {
        if(s.length() == 0) return s;
        StringBuilder result = remove(s, '(', ')');
        result = remove(result.reverse().toString(), ')', '(');
        return result.reverse().toString();
    }

    private StringBuilder remove(String s, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for(char c : s.toCharArray()) {
            if(c == open) {
                balance++;
            } else if(c == close) {
                if(balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }
}
