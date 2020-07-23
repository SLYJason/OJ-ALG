package LeetCode.Design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution 2: brute force, intuitive thought
 */
public class LeetCode1268_Sol2 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode();

        for(String product : products) {
            insert(root, product);
        }

        return search(root, searchWord);
    }

    private void insert(TrieNode root, String product) {
        TrieNode curr = root;
        for(char ch : product.toCharArray()) {
            if(curr.childern[ch - 'a'] == null) {
                curr.childern[ch - 'a'] = new TrieNode();
            }
            curr = curr.childern[ch - 'a'];
            if(curr.suggestions.size() < 3) {
                curr.suggestions.add(product);
            }
        }
    }

    private List<List<String>> search(TrieNode root, String searchWord) {
        List<List<String>> ans = new LinkedList();
        TrieNode curr = root;
        for(char ch : searchWord.toCharArray()) {
            if(curr != null) {
                curr = curr.childern[ch - 'a'];
            }
            ans.add(curr == null ? new LinkedList() : curr.suggestions);
        }
        return ans;
    }

    class TrieNode {
        public TrieNode[] childern;
        public List<String> suggestions;
        public TrieNode() {
            childern = new TrieNode[26];
            this.suggestions = new LinkedList();
        }
    }
}
