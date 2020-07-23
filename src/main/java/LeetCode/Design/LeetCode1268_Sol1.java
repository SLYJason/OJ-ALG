package LeetCode.Design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution 1: brute force, intuitive thought
 */
public class LeetCode1268_Sol1 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int len = searchWord.length();
        List<List<String>> ans = new LinkedList();
        for(int i=1; i<=len; i++) {
            String prefix = searchWord.substring(0, i);
            List<String> list = new LinkedList();
            for(String product : products) {
                if(list.size() == 3) break;
                if(product.startsWith(prefix)) {
                    list.add(product);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
