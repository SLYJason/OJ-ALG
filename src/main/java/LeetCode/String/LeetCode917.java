package LeetCode.String;

public class LeetCode917 {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        int left = 0, right = sb.length()-1;
        while(left < right) {
            char a = sb.charAt(left);
            char b = sb.charAt(right);
            if(Character.isAlphabetic(a) && Character.isAlphabetic(b)) {
                sb.setCharAt(left++, b);
                sb.setCharAt(right--, a);
            } else if(Character.isAlphabetic(a)) {
                right--;
            } else if(Character.isAlphabetic(b)) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return sb.toString();
    }
}
