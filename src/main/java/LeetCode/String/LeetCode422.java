package LeetCode.String;

import java.util.List;

public class LeetCode422 {
    /**
     * Solution 1: intuitive thought
     */
    public boolean validWordSquare(List<String> words) {
        int k = words.size();
        for(int i=0, j=0; i<k; i++, j++) {
            String row = words.get(i);
            String col = "";
            for(String word : words) {
                if(j < word.length()) col += Character.toString(word.charAt(j));
            }
            if(!row.equals(col)) return false;
        }
        return true;
    }

    /**
     * Solution 2: optimal solution
     */
    public boolean validWordSquare2(List<String> words) {
        int k = words.size();
        try {
            for(int i=0; i<k; i++) {
                for(int j=0; j<words.get(i).length(); j++) {
                    if(words.get(i).charAt(j) != words.get(j).charAt(i)) {
                        return false;
                    }
                }
            }
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
