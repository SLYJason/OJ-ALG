package LeetCode.LC127;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: optimal, Bidirectional BFS.
 * Sometimes does not need Queue in BFS, Set should also working.
 */
public class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> dict = new HashSet(wordList);
        int steps = 0;
        Set<String> queue1 = new HashSet();
        Set<String> queue2 = new HashSet();
        queue1.add(beginWord);
        queue2.add(endWord);
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            steps++;
            // This is bidirectional BFS starts.
            if (queue1.size() > queue2.size()) {
                Set<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
            }
            Set<String> next = new HashSet<>();

            for(String begin : queue1) {
                char[] tranform = begin.toCharArray();
                // change jth position from 'a' -> 'z' in begin.
                for(int j=0; j<begin.length(); j++) {
                    char temp = tranform[j];
                    for(int k='a'; k<='z'; k++) {
                        tranform[j] = (char)k;
                        String transformed = new String(tranform);
                        if(queue2.contains(transformed)) return steps + 1;
                        if(!dict.contains(transformed)) continue;
                        dict.remove(transformed);
                        next.add(transformed);
                    }
                    tranform[j] = temp;
                }
            }
            queue1 = next;
        }
        return 0;
    }
}
