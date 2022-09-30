package LeetCode.LC_2201_2400.LC2296;

/**
 * Solution 1: StringBuilder.
 */
public class Solution_1 {
    class TextEditor {
        StringBuilder sb;
        int cursor;
        public TextEditor() {
            sb = new StringBuilder();
            cursor = 0;
        }

        public void addText(String text) {
            sb.insert(cursor, text);
            cursor += text.length();
        }

        public int deleteText(int k) {
            int deleted = cursor - k;
            if (deleted < 0) {
                deleted = cursor;
                sb.delete(0, cursor);
                cursor = 0;
                return deleted;
            }
            sb.delete(deleted, cursor);
            cursor = deleted;
            return k;
        }

        public String cursorLeft(int k) {
            int moved = cursor - k;
            if (moved < 0) {
                cursor = 0;
            } else {
                cursor = moved;
            }
            return sb.substring(Math.max(cursor - Math.min(10, sb.length()), 0), cursor);
        }

        public String cursorRight(int k) {
            int moved = cursor + k;
            if (moved > sb.length()) {
                cursor = sb.length();
            } else {
                cursor = moved;
            }
            return sb.substring(Math.max(cursor - Math.min(10, sb.length()), 0), cursor);
        }
    }
}
