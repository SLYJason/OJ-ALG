package LeetCode.LC_601_800.LC767;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution: using PriorityQueue (Heap).
 * Logic is alternate placing the most common letters.
 */
public class Solution_1 {
    public String reorganizeString(String S) {
        if(S.length() <= 1) return S;
        int[] count = new int[26]; // count each character's frequency.
        for(char ch : S.toCharArray()) {
            count[ch - 'a']++;
            if(count[ch - 'a'] > (S.length()+1)/2) return ""; // can not reorganize the String.
        }
        PriorityQueue<CharCount> pq = new PriorityQueue(new Comparator<CharCount>(){
            @Override
            public int compare(CharCount a, CharCount b) {
                if(a.count == b.count) return a.ch - b.ch;
                return b.count - a.count;
            }
        });
        for(int i=0; i<26; i++) {
            char ch = (char)('a' + i);
            int c = count[i];
            if(c != 0) pq.offer(new CharCount(ch, c)); // build and push the CharCount to the PriorityQueue.
        }

        // process PriorityQueue to build the final results.
        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2) {
            CharCount charCount1 = pq.poll();
            CharCount charCount2 = pq.poll();
            sb.append(charCount1.ch);
            sb.append(charCount2.ch);
            if(--charCount1.count > 0) pq.offer(charCount1);
            if(--charCount2.count > 0) pq.offer(charCount2);
        }
        if(!pq.isEmpty()) sb.append(pq.poll().ch);
        return sb.toString();
    }

    class CharCount {
        char ch; // character of the S.
        int count; // frequency of the character.
        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
