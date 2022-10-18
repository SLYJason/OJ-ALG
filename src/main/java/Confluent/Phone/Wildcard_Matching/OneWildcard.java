package Confluent.Phone.Wildcard_Matching;

/**
 * The pattern only has 1 wildcard.
 */
public class OneWildcard {
    public static boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) return true;
        if (p.isEmpty()) return false;
        if (!p.contains("*")) return s.equals(p);

        int index = p.indexOf('*');
        String prefix = p.substring(0, index), suffix = p.substring(index + 1);
        if (prefix.isEmpty() && suffix.isEmpty()) return true;
        if (prefix.isEmpty()) return s.endsWith(suffix);
        if (suffix.isEmpty()) return s.startsWith(prefix);
        return s.startsWith(prefix) && s.substring(prefix.length()).endsWith(suffix);
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
    }

    private static String verify(boolean expected, boolean actual) {
        return expected == actual ? "Pass" : "Fail";
    }
}
