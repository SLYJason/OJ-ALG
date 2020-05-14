package LeetCode.SystemDesign;

public class LeetCode208 {
    class Trie {
        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                if(node.trieNodes[ch - 'a'] == null) node.trieNodes[ch - 'a'] = new TrieNode();
                node = node.trieNodes[ch - 'a'];
            }
            node.isEndWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = find(word);
            return node != null && node.isEndWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = find(prefix);
            return node != null;
        }

        /** Helper to find a TrieNode is exist or not contains the word */
        private TrieNode find(String word) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                if(node.trieNodes[ch - 'a'] == null) return null;
                node = node.trieNodes[ch - 'a'];
            }
            return node;
        }
    }

    class TrieNode {
        public TrieNode[] trieNodes;
        public boolean isEndWord;
        TrieNode() {
            trieNodes = new TrieNode[26];
            isEndWord = false;
        }
    }
}
