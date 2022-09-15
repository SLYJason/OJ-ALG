package LeetCode.LC_601_800.LC767;

import java.util.PriorityQueue;

/**
 * Solution: PriorityQueue.
 */
public class Solution_1 {
    public String reorganizeString(String s) {
        if (s.length() <= 1) return s;

        // step 1: count each character frequency.
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int count = ++counter[s.charAt(i) - 'a'];
            if (count > (s.length() + 1) / 2) return ""; // can not reorganize the String.
        }

        // step 2: build the priority queue based on the Pair.
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.getCount() - p1.getCount());
        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0) pq.offer(new Pair((char)('a' + i), counter[i]));
        }

        // step 3: insert the most frequent char into the result every other slot.
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();
            sb.append(p1.getChar()).append(p2.getChar());
            if (p1.getCount() - 1 > 0) pq.offer(new Pair(p1.getChar(), p1.getCount() - 1));
            if (p2.getCount() - 1 > 0) pq.offer(new Pair(p2.getChar(), p2.getCount() - 1));
        }

        // step 4: insert the last Pair char (if exist) into the result.
        while (!pq.isEmpty()) sb.append(pq.poll().getChar());
        return sb.toString();
    }

    class Pair {
        private char ch;
        private int count;
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public char getChar() {
            return ch;
        }

        public int getCount() {
            return count;
        }

        public String toString() {
            return ch + "->" + count;
        }
    }
}
