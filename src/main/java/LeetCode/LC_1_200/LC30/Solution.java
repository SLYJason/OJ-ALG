package LeetCode.LC_1_200.LC30;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: sliding window.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> words_count = new HashMap<>();
        for(String word : words) words_count.put(word, words_count.getOrDefault(word, 0) + 1);

        List<Integer> res = new ArrayList();
        int word_len = words[0].length(), words_num = words.length;
        int total_length = word_len * words_num;

        for(int i=0; i<s.length() - total_length + 1; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            int j = i;
            while(j < i + total_length) {
                String word = s.substring(j, j+word_len);
                tmp.put(word, tmp.getOrDefault(word, 0) + 1);
                if(!words_count.containsKey(word)) break; // current word not exist in the words.
                if(tmp.get(word) > words_count.get(word)) break; // current word count is bigger.
                j += word_len;
            }
            // add index i if the window string is concatenation of the words.
            if(j == i + total_length) res.add(i);
        }

        return res;
    }
}
