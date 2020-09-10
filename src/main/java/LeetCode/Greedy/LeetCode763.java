package LeetCode.Greedy;

import java.util.List;
import java.util.LinkedList;

public class LeetCode763 {
    /**
     * Solution 1: brute force, intuitive thoughts.
     * For any given character ch with a index i, find the last appearance index end.
     * Then inside the [i, end] substring, find every character last appearance index, if it larger than the index end then update it.
     *
     * Time Complexity: O(n^2).
     * Space Complexity: O(n).
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<S.length(); ) {
            char ch = S.charAt(i);
            int start = i;
            int end = S.lastIndexOf(ch);
            while(++start < end) {
                char next = S.charAt(start);
                if(S.lastIndexOf(next) > end) {
                    end = S.lastIndexOf(next);
                }
            }
            res.add(end-i+1);
            i = end+1;
        }
        return res;
    }

    /**
     * Solution 2: optimal solution.
     * Time Complexity: O(n).
     * Space Complexity: O(1).
     */
    public List<Integer> partitionLabels2(String S) {
        List<Integer> res = new LinkedList();
        int[] last_index = new int[26];
        for(int i=0; i<S.length(); i++) {
            last_index[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<S.length(); i++) {
            end = Math.max(end, last_index[S.charAt(i) - 'a']);
            if(i == end) {
                res.add(end-start+1);
                start = i+1;
            }
        }
        return res;
    }
}
