package LeetCode.LC_601_800.LC767;

public class Solution_2 {
    public String reorganizeString(String S) {
        if(S.length() <= 1) return S;
        int[] counter = new int[26];
        char max_frequency_char = 'a'; // max frequency character.
        int max_frequency = 0; // max frequency.
        // Step 1: count each character's frequency, find max_frequency_char and max_frequency.
        for(char ch : S.toCharArray()) {
            counter[ch - 'a']++;
            if(counter[ch - 'a'] > max_frequency) {
                max_frequency = counter[ch - 'a'];
                max_frequency_char = ch;
            }
        }

        if(max_frequency > (S.length()+1)/2) return ""; // can not reorganize the String.

        char[] reorg = new char[S.length()]; // final results.
        int index = 0;
        // Step 2: fill the reorgnized String with max_frequency_char first.
        while(counter[max_frequency_char - 'a'] > 0) {
            reorg[index] = max_frequency_char;
            --counter[max_frequency_char - 'a'];
            index += 2;
        }

        // Step 3: fill the rest characters.
        for(int i=0; i<26; i++) {
            while(counter[i] > 0) {
                if(index >= reorg.length) index = 1;
                reorg[index] = (char)(i + 'a');
                index += 2;
                --counter[i];
            }
        }
        return new String(reorg);
    }
}
