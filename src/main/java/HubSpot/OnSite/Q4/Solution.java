package HubSpot.OnSite.Q4;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> getPalindromes(String[] strings) {
        if (strings == null || strings.length == 0) return null;
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            String palindrome = makePalindrome(s);
            if (palindrome != null) list.add(makePalindrome(s));
        }
        return list;
    }

    public static String makePalindrome(String s) {
        if (s.length() < 2) return s;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // verify can make palindrome.
        int odd = 0;
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] % 2 != 0) odd++;
            if (odd > 1) return null;
        }

        char[] palindrome = new char[s.length()];
        int left = 0, right = s.length() - 1;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            if (count[i] % 2 != 0) {
                palindrome[s.length() / 2] = (char)(i + 'a');
                --count[i];
            }
            while (count[i] > 0) {
                palindrome[left++] = (char)(i + 'a');
                palindrome[right--] = (char)(i + 'a');
                count[i] = count[i] - 2;
            }
        }
        return new String(palindrome);
    }

    public static void main(String[] args) {
        String[] s1 = {"abc", "abab", "geekgeek", "huuhi", "ooiiqw"};
        System.out.println(getPalindromes(s1));
    }
}
