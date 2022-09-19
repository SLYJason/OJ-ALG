package HubSpot.OnSite.Q1;

import java.util.*;

public class Solution {
    public static List<String> nGramString(String s, int n) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        if (n >= s.length()) return new ArrayList<>() {
            {
                add(s);
            }
        };

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - n; i++) {
            String sub = s.substring(i, i + n);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        List<String> list = new LinkedList<>();
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                list.clear();
                list.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(nGramString("abcdef", 3));
        System.out.println(nGramString("abcabc", 3));
        System.out.println(nGramString("abcabcdefdef", 3));
    }
}
