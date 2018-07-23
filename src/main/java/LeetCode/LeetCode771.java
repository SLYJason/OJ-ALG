package LeetCode;

import java.util.Set;
import java.util.HashSet;

public class LeetCode771 {
    public int numJewelsInStones(String J, String S) {
        int total = 0;
        Set set = new HashSet<Character>();
        for(char j:J.toCharArray()) {
            set.add(j);
        }
        for(char s:S.toCharArray()) {
            if(set.contains(s)) {
                total++;
            }
        }
        return total;
    }
}
