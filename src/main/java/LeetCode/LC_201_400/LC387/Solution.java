package LeetCode.LC_201_400.LC387;

public class Solution {
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        // Building an array that stores each character appearance times
        for(Character ch:s.toCharArray()) {
            array[ch-'a']++;
        }
        // Find the index
        for (int i=0; i<s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
