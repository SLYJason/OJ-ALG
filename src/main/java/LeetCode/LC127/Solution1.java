package LeetCode.LC127;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

/**
 * Solution: BFS.
 */
public class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> dict = new HashSet<>(wordList); // Important: conver to set can get rid of TLE.
        int steps = 0;
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            steps++;
            for(int i=queue.size(); i>0; i--) {
                String begin = queue.poll();
                char[] tranform = begin.toCharArray();
                // change jth position from 'a' -> 'z' in begin.
                for(int j=0; j<begin.length(); j++) {
                    char temp = tranform[j];
                    for(int k='a'; k<='z'; k++) {
                        tranform[j] = (char)k;
                        String transformed = new String(tranform);
                        if(transformed.equals(endWord)) return steps+1;
                        if(!dict.contains(transformed)) continue;
                        dict.remove(transformed);
                        queue.offer(transformed);
                    }
                    tranform[j] = temp;
                }
            }
        }
        return 0;
    }
}
