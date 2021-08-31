package LeetCode.LC_201_400.LC370;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int i = 0; i < updates.length; i++) {
            for(int j = updates[i][0]; j <= updates[i][1]; j++) {
                arr[j] += updates[i][2];
            }
        }
        return arr;
    }
}
