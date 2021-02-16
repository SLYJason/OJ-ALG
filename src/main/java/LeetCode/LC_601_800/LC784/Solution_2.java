package LeetCode.LC_601_800.LC784;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

/**
 * Solution 2: BFS.
 */
public class Solution_2 {
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isAlphabetic(c)) {
                for(int j=queue.size(); j>0; j--) {
                    char[] CH = queue.poll().toCharArray();
                    // convert to upper case.
                    CH[i] = Character.toLowerCase(c);
                    queue.offer(new String(CH));
                    // convert to lower case.
                    CH[i] = Character.toUpperCase(c);
                    queue.offer(new String(CH));
                }
            }
        }
        return (List<String>)queue;
    }
}
