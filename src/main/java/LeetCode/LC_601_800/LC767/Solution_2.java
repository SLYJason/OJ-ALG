package LeetCode.LC_601_800.LC767;

/**
 * Solution 2: smart filling.
 */
public class Solution_2 {
    public String reorganizeString(String s) {
        if(s.length() <= 1) return s;

        // Step 1: count each character's frequency, find max_frequency_char and max_frequency.
        int[] counter = new int[26];
        char max_frequency_char = 'a'; // max frequency character.
        int max_frequency = 0; // max frequency.
        for (char ch : s.toCharArray()) {
            counter[ch - 'a']++;
            if (counter[ch - 'a'] > max_frequency) {
                max_frequency = counter[ch - 'a'];
                max_frequency_char = ch;
            }
        }
        if (max_frequency > (s.length() + 1) / 2) return ""; // can not reorganize the String.

        // Step 2: fill the reorganized String with max_frequency_char first.
        char[] reorg = new char[s.length()]; // final results.
        int index = 0;
        while (counter[max_frequency_char - 'a'] > 0) {
            reorg[index] = max_frequency_char;
            --counter[max_frequency_char - 'a'];
            index += 2;
        }

        // Step 3: fill the rest characters.
        for(int i = 0; i < 26; i++) {
            while (counter[i] > 0) {
                if (index >= reorg.length) index = 1;
                reorg[index] = (char)(i + 'a');
                index += 2;
                --counter[i];
            }
        }
        return new String(reorg);
    }
}
