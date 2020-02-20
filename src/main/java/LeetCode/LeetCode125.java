package LeetCode;

public class LeetCode125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        for(int l=0, r=s.length()-1; l<r;) {
            char chLeft = s.charAt(l);
            char chRight = s.charAt(r);
            if (!Character.isLetterOrDigit(chLeft)) {
                l++;
            } else if (!Character.isLetterOrDigit(chRight)) {
                r--;
            } else {
                if (chLeft != chRight) return false;
                l++;
                r--;
            }
        }
        return true;
    }
}
