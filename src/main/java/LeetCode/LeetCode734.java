package LeetCode;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LeetCode734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Set<String> set = new HashSet();
        for(List<String> pair : pairs) {
            set.add(pair.get(0) + "#" + pair.get(1));
        }
        System.out.println(set);
        for(int i=0; i<words1.length; i++) {
            if (!words1[i].equals(words2[i]) &&
                    !set.contains(words1[i]+"#"+words2[i]) &&
                    !set.contains(words2[i]+"#"+words1[i])) return false;
        }
        return true;
    }
}
