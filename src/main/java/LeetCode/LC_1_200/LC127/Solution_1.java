package LeetCode.LC_1_200.LC127;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

/**
 * Solution 1: BFS.
 */
public class Solution_1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> dict = new HashSet<>(wordList); // Important: convert to set can get rid of TLE.
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            while(size-- > 0) {
                String cur = queue.poll();
                char[] arr = cur.toCharArray();
                for(int i=0; i<arr.length; i++) {
                    char ori = arr[i];
                    for(int k='a'; k<='z'; k++) {
                        arr[i] = (char)k;
                        String next = new String(arr);
                        if(endWord.equals(next)) return steps + 1;
                        if(dict.contains(next)) {
                            dict.remove(next);
                            queue.offer(next);
                        }
                    }
                    arr[i] = ori;
                }
            }
        }
        return 0;
    }
}
