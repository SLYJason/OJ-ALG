package LeetCode;

public class LeetCode557 {
    public String reverseWords(String s) {
        String reversed = "";
        for(int start=0; start<s.length(); start++) {
            int end = start;
            while(end<s.length() && s.charAt(end) != ' ') end++;
            reversed += reverse(s.substring(start, end)) + " ";
            start=end;
        }
        return reversed.trim();
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int start=0, end=chars.length-1;
        while(start<end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
}
