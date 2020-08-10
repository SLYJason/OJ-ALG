package LeetCode.Math;

public class LeetCode171 {
    public int titleToNumber(String s) {
        int num = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            num += Math.pow(26, s.length()-i-1) * (ch -'A' + 1);
        }
        return num;
    }
}
