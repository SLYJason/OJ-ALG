package LeetCode.LC_1001_1200.LC1032;

public class Solution_1 {
    class StreamChecker {
        String[] words;
        StringBuilder sb;

        public StreamChecker(String[] words) {
            this.sb = new StringBuilder();
            this.words = words;
        }

        public boolean query(char letter) {
            sb.append(letter);
            for (String word : words) {
                int suffixIndex = sb.length() - word.length();
                if (suffixIndex > -1 && sb.substring(suffixIndex).equals(word)) return true;
            }
            return false;
        }
    }
}
