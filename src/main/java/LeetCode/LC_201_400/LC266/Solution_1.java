package LeetCode.LC_201_400.LC266;

/**
 * Solution 1: array single pass.
 */
public class Solution_1 {
    public boolean canPermutePalindrome(String s) {
        int[] array = new int[128];
        int count = 0;
        for(char ch:s.toCharArray()) {
            array[ch]++;
            if(array[ch] % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }
}
