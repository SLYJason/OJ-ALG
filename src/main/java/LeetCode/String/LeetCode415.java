package LeetCode.String;

public class LeetCode415 {
    /**
     * Solution 1: intuitive thoughts
     */
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int p1 = num1.length()-1, p2 = num2.length()-1;
        boolean carry = false;
        String ans = "";
        while(p1 > -1 && p2 > -1) {
            int a = Character.getNumericValue(num1.charAt(p1--));
            int b = Character.getNumericValue(num2.charAt(p2--));
            int sum = carry ? a + b + 1 : a + b;
            if(sum >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            ans = sum % 10 + ans;
        }
        while(p1 > -1) {
            int a = Character.getNumericValue(num1.charAt(p1--));
            int sum = carry ? a + 1 : a;
            if(sum >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            ans = sum % 10 + ans;
        }
        return carry ? ans = "1" + ans : ans;
    }

    /**
     * Solution 2: optimal solution, clean code
     */
    public String addStrings2(String num1, String num2) {
        int p1 = num1.length()-1, p2 = num2.length()-1;
        String ans = "";
        int carry = 0;
        while(p1 > -1 || p2 > -1) {
            int a = p1 > -1 ? Character.getNumericValue(num1.charAt(p1--)) : 0;
            int b = p2 > -1 ? Character.getNumericValue(num2.charAt(p2--)) : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            ans = sum % 10 + ans;
        }
        return carry == 1 ? 1 + ans : ans;
    }
}
