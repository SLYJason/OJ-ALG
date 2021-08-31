package LeetCode.LC_201_400.LC370;

import java.util.Arrays;

/**
 * Solution: optimized.
 */
public class Solution_2 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length + 1];
        for(int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            arr[start] += inc;
            arr[end + 1] -= inc;
        }
        for(int i = 1; i < length + 1; i++) {
            arr[i] += arr[i - 1];
        }
        return Arrays.copyOf(arr, length);
    }
}
