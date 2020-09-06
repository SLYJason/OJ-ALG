package LeetCode.String;

/**
 * Solution 1: intuitive thoughts.
 */
public class LeetCode953_Sol1 {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0; i<words.length-1; i++) {
            String wordA = words[i];
            String wordB = words[i+1];
            if(!isLexicographicaly(wordA, wordB, order)) return false;
        }
        return true;
    }

    private boolean isLexicographicaly(String wordA, String wordB, String order) {
        if(wordA.equals(wordB)) return true; // case1: both wordA and wordB are equal.
        int i = 0, j = 0;
        while(i < wordA.length() && j < wordB.length()
                && wordA.charAt(i) == wordB.charAt(j)) {
            i++;
            j++;
        }
        if(i == wordA.length()) return true; // case2: "app" vs "apple".
        if(j == wordB.length()) return false; // case3: "apple" vs "app".
        return order.indexOf(wordA.charAt(i)) < order.indexOf(wordB.charAt(j));
    }
}
