package Confluent.Phone.Wildcard_Matching;

public class MultiWildcard {
    public static boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) return true;
        if (p.isEmpty()) return false;

        int n1 = s.length(), n2 = p.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        // step 1: initialization.
        for (int i = 1; i <= n2; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        // step 2: DP.
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = p.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (ch2 == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(verify(isMatch("", ""), true)); // true
        System.out.println(verify(isMatch("cat", ""), false)); // false.
        System.out.println(verify(isMatch("", "cat"), false)); // false.
        System.out.println(verify(isMatch("", "*"), true)); // true.

        System.out.println(verify(isMatch("a", "a*a"), false)); // false.
        System.out.println(verify(isMatch("abcgh", "*"), true)); // true.
        System.out.println(verify(isMatch("ab", "*ab"), true)); // true.
        System.out.println(verify(isMatch("ab", "ab*"), true)); // true.
        System.out.println(verify(isMatch("ab", "ac*"), false)); // false.

        System.out.println(verify(isMatch("cat", "cat"), true)); // true.
        System.out.println(verify(isMatch("cat", "c*t"), true)); // true.
        System.out.println(verify(isMatch("cat", "*t"), true)); // true.
        System.out.println(verify(isMatch("dog", "ct"), false)); // false.
        System.out.println(verify(isMatch("cat", "tac*"), false)); // false.

        System.out.println(verify(isMatch("cat", "*t*a*c*"), false)); // false.
        System.out.println(verify(isMatch("catcatcat", "cat*cat*cat***"), true)); // true.
        System.out.println(verify(isMatch("fdajhfjdsacatcatcatlsaflk", "****cat*cat*cat***"), true)); // true.
        System.out.println(verify(isMatch("cat", "cat*cat"), false)); // false.
        System.out.println(verify(isMatch("catat", "ca*t"), true)); // false.
    }

    private static String verify(boolean expected, boolean actual) {
        return expected == actual ? "Pass" : "Fail";
    }
}
