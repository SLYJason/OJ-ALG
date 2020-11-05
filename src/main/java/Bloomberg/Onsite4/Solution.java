package Bloomberg.Onsite4;

public class Solution {
    public static void main(String args[] ) throws Exception {
        String s1 = "aaabbbc";
        String s2 = "aabbbacd";
        String s3 = "aabbccddeeedcba";
        String s4 = "aaabbbacd";
        String s5 = "ABBBCC";
        String s6 = "ABCCCBB";
        String s7 = "ABBBBBBBBCC";
        String s8 = "ABCCCCCCCCCBDDDBAA";
        System.out.println(crush(s1)); // "c"
        System.out.println(crush(s2)); // "cd
        System.out.println(crush(s3)); // ""
        System.out.println(crush(s4)); // "acd"
        System.out.println(crush(s5)); // "ACC"
        System.out.println(crush(s6)); // "A"
        System.out.println(crush(s7)); // "ACC
        System.out.println(crush(s8)); // ""
    }

    private static String crush(String s) {
        if(s.length() <= 2) return s;
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++) {
            int j=i+1;
            while(j < sb.length() && sb.charAt(i) == sb.charAt(j)) {
                j++;
            }
            if(j - i >= 3) {
                sb.delete(i, j);
                i = -1;
            }
        }
        return sb.toString();
    }
}
