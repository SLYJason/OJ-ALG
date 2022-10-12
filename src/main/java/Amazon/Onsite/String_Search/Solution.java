package Amazon.Onsite.String_Search;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static Map<String, List<Integer>> query(String doc, List<String> queries) {
        Map<String, List<Integer>> map = new HashMap<>();
        Map<String, int[]> lpsMap = new HashMap<>();
        for (String query : queries) {
            map.put(query, new ArrayList<>());
            lpsMap.put(query, computerLps(query));
        }

        String[] splits = doc.split(" ");
        for (int i = 0; i < splits.length; i++) {
            String str = splits[i];
            for (String query : queries) {
                int[] lps = lpsMap.get(query);
                int j = 0, k = 0;
                while (j < str.length()) {
                    if (str.charAt(j) == query.charAt(k)) {
                        j++;
                        k++;
                        if (k == query.length()) {
                            map.get(query).add(i); // find the match.
                            k = 0;
                        }
                    } else {
                        if (k - 1 >= 0) {
                            k = lps[k - 1];
                        } else {
                            j++;
                        }
                    }
                }
            }
        }
        return map;
    }

    // get KMP longest proper prefix/suffix array
    public static int[] computerLps(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = ++j;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String doc = "Hello all today we are going to discuss ll efefefe lllgegege";
        List<String> queries = new ArrayList<>();
        queries.add("ll");
        queries.add("ss");
        System.out.println(query(doc, queries));
    }
}
