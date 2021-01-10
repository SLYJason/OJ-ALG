package LeetCode.LC_1_200.LC127;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: bidirectional BFS.
 */
public class Solution_2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> dict = new HashSet<>(wordList);
        int steps = 0;
        Set<String> queue1 = new HashSet<>();
        Set<String> queue2 = new HashSet<>();
        queue1.add(beginWord);
        queue2.add(endWord);
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            steps++;
            // optimization: always start from queue with smaller size.
            if (queue1.size() > queue2.size()) {
                Set<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
            }
            Set<String> next_queue = new HashSet<>();

            for(String begin : queue1) {
                char[] arr = begin.toCharArray();
                // change jth position from 'a' -> 'z' in begin.
                for(int j=0; j<begin.length(); j++) {
                    char ori = arr[j];
                    for(int k='a'; k<='z'; k++) {
                        arr[j] = (char)k;
                        String next = new String(arr);
                        if(queue2.contains(next)) return steps + 1;
                        if(dict.contains(next)) {
                            dict.remove(next);
                            next_queue.add(next);
                        }
                    }
                    arr[j] = ori;
                }
            }
            queue1 = next_queue;
        }
        return 0;
    }
}
