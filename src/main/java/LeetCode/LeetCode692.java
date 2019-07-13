package LeetCode;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LeetCode692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap();
        for (String word:words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        }
        List<String> topKList = new ArrayList(wordCount.keySet());
        Collections.sort(topKList, (w1, w2) ->
                wordCount.get(w1) == wordCount.get(w2) ? w1.compareTo(w2) : wordCount.get(w2) - wordCount.get(w1)
        );
        return topKList.subList(0, k);
    }
}
