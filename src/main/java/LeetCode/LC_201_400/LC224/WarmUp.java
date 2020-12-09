package LeetCode.LC_201_400.LC224;

public class WarmUp {
    public static int calculate(String s) {
        int sum = 0, sign = 1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)) {
                int num = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }
                sum += sign * num;
            } else if(c == '+') {
                sign = 1;
            } else {
                sign = -1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = " 20- 11 + 9  ";
        String s4 = " -3  - 2 + 7  ";
        System.out.println(calculate(s1));
        System.out.println(calculate(s2));
        System.out.println(calculate(s3));
        System.out.println(calculate(s4));
    }
}
