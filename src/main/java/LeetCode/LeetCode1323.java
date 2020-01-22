package LeetCode;

public class LeetCode1323 {
    public int maximum69Number (int num) {
        char[] charnum = String.valueOf(num).toCharArray();
        for(int i=0; i<charnum.length; i++) {
            if (charnum[i] == '6') {
                charnum[i] = '9';
                break;
            }
        }
        return Integer.valueOf(String.valueOf(charnum));
    }
}
