package LeetCode.LC_1_200.LC32;

/**
 * Solution 3: two direction scan.
 */
public class Solution_3 {
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        int max_length = 0, left = 0, right = 0;
        // left -> right scan.
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                max_length = Math.max(max_length, left*2);
            } else if(left < right) {
                left = right = 0;
            }
        }
        // right -> left scan.
        left = right = 0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                max_length = Math.max(max_length, left*2);
            } else if(left > right) {
                left = right = 0;
            }
        }
        return max_length;
    }
}
