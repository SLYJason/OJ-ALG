package LeetCode.String;

public class LeetCode482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for(int i = S.length()-1, j=0; i >= 0; i--) {
            if(S.charAt(i) != '-') {
                char ch = Character.toUpperCase(S.charAt(i));
                if(j == K) {
                    j = 0;
                    sb.append("-");
                }
                sb.append(ch);
                j++;
            }
        }
        return sb.reverse().toString();
    }
}
