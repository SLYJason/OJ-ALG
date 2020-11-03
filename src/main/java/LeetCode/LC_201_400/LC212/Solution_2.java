package LeetCode.LC_201_400.LC212;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: using Trie, the benefit is some word may share same prefixes, using Trie can save time.
 */
public class Solution_2 {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode root, List<String> res) {
        char ch = board[r][c];
        if(ch == '#' || root.children[ch - 'a'] == null) return;
        root = root.children[ch - 'a'];

        if(root.word != null) { // find a word.
            res.add(root.word);
            root.word = null; // de-duplicate.
        }

        board[r][c] = '#';
        for(int[] dir : dirs) {
            int nx = r + dir[0];
            int ny = c + dir[1];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                dfs(board, nx, ny, root, res);
            }
        }
        board[r][c] = ch; // backtrack.
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode cur = root;
            for(char ch : word.toCharArray()) {
                if(cur.children[ch - 'a'] == null) cur.children[ch - 'a'] = new TrieNode();
                cur = cur.children[ch - 'a'];
            }
            cur.word = word;
        }
        return root;
    }

    class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }
}
