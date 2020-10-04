package LeetCode.LC_201_400.LC227;

public class Solution {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        int res = 0;
        int sign = 1;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int num = 0;
            if(Character.isDigit(ch)) {
                num = s.charAt(i) - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }

                if(i+1 < s.length() && s.charAt(i+1) == '+') {

                } else if(i+1 < s.length() && s.charAt(i+1) == '-') {

                } else if(i+1 < s.length() && s.charAt(i+1) == '*') {

                } else if(i+1 < s.length() && s.charAt(i+1) == '/') {

                }
            }
        }
        return res;
    }
}
