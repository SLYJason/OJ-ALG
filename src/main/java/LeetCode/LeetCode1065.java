package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class LeetCode1065 {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> indexes = new ArrayList();
        for(int i=0; i<text.length(); i++) {
            for(int j=i+1; j<text.length()+1; j++) {
                String subWord = text.substring(i, j);
                for (String s : words) {
                    if (subWord.equals(s)) {
                        int[] index = new int[]{i, j-1};
                        indexes.add(index);
                    }
                }
            }
        }
        return indexes.toArray(new int[indexes.size()][]);
    }
}
