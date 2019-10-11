package LeetCode;

public class LeetCode443 {
    public int compress(char[] chars) {
        int p1 = 0, p2 = 0;
        while(p2 < chars.length) {
            char currChar = chars[p2];
            int count = 0;
            while(p2 < chars.length && currChar == chars[p2]) {
                count++;
                p2++;
            }
            chars[p1++] = currChar;
            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[p1++] = ch;
                }
            }

        }
        return p1;
    }
}
