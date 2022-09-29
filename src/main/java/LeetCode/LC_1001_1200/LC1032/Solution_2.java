package LeetCode.LC_1001_1200.LC1032;

import java.util.ArrayDeque;

/**
 * Solution 2: trie.
 */
public class Solution_2 {
    class TrieNode {
        TrieNode[] children;
        boolean word;

        TrieNode() {
            children = new TrieNode[26];
            word = false;
        }
    }


    class StreamChecker {
        ArrayDeque<Character> deque;
        TrieNode root;

        public StreamChecker(String[] words) {
            deque = new ArrayDeque<>();
            root = new TrieNode();

            for (String word : words) {
                TrieNode node = root;
                String reversed = new StringBuilder(word).reverse().toString();
                for (char ch : reversed.toCharArray()) {
                    if (node.children[ch - 'a'] == null) {
                        node.children[ch - 'a'] = new TrieNode();
                    }
                    node = node.children[ch - 'a'];
                }
                node.word = true;
            }
        }

        public boolean query(char letter) {
            deque.addFirst(letter);
            TrieNode node = root;

            for (char ch : deque) {
                if (node.word) return true;

                node = node.children[ch - 'a'];
                if (node == null) return false;
            }
            return node.word;
        }
    }
}
