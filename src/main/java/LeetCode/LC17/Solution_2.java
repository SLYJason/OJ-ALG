package LeetCode.LC17;

import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Solution 2: BFS.
 */
public class Solution_2 {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList();
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList();
        queue.offer("");
        for(char num : digits.toCharArray()) {
            String str = dict[Character.getNumericValue(num)];
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String combination = queue.poll();
                for(char ch : str.toCharArray()) {
                    queue.offer(combination + ch);
                }
            }
        }
        return (List<String>)queue;
    }
}
