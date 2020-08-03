package LeetCode.String;

public class LeetCode520 {
    public boolean detectCapitalUse(String word) {
        if(word.equals(word.toUpperCase())) return true; // 1st case
        if(word.equals(word.toLowerCase())) return true; // 2nd case
        char first = word.charAt(0);
        if(first >= 'A' && first <= 'Z' && word.substring(1).equals(word.toLowerCase().substring(1))) return true; // 3rd casr
        return false;
    }
}
