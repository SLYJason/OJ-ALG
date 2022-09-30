package LeetCode.LC_2201_2400.LC2296;

import java.util.ArrayDeque;

public class Solution_2 {
    class TextEditor {
        ArrayDeque<Character> left;
        ArrayDeque<Character> right;

        public TextEditor() {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
        }

        public void addText(String text) {
            for (char ch : text.toCharArray()) {
                left.push(ch);
            }
        }

        public int deleteText(int k) {
            int size = left.size(), deleted = k;
            while (!left.isEmpty() && deleted > 0) {
                left.pop();
                deleted--;
            }
            // System.out.println(left);
            // System.out.println(right);
            return left.isEmpty() ? size : k;
        }

        public String cursorLeft(int k) {
            while (!left.isEmpty() && k > 0) {
                right.push(left.pop());
                k--;
            }
            return getLast10();
        }

        public String cursorRight(int k) {
            while (!right.isEmpty() && k > 0) {
                left.push(right.pop());
                k--;
            }
            return getLast10();
        }

        private String getLast10() {
            // System.out.println(left);
            int count = 10;
            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty() && count > 0) {
                count--;
                sb.append(left.pop());
            }
            sb = sb.reverse();
            for (char ch : sb.toString().toCharArray()) {
                left.push(ch);
            }
            return sb.toString();
        }
    }
}
