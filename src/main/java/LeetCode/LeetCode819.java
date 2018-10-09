package LeetCode;

import java.util.*;

public class LeetCode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        String[] pa = paragraph.split("[!?',;. ]");
        int maxCount = 0;
        String maxString = "";
        for(int i=0; i<pa.length; i++) {
            String word = pa[i].toLowerCase();
            if(!Arrays.asList(banned).contains(word) && !word.isEmpty()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
                if (wordMap.get(word) > maxCount) {
                    maxCount = wordMap.get(word);
                    maxString = word;
                }
            }
        }
        return maxString;
    }
}
