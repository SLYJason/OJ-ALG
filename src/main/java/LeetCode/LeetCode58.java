package LeetCode;

public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.trim().length() - 1 - s.trim().lastIndexOf(" ");
    }
}
