package LeetCode.LC_401_600.LC573;

/**
 * Solution 2: single pass.
 */
public class Solution_2 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int dist = 0, d = Integer.MIN_VALUE;
        for(int[] nut : nuts) {
            dist += distance(nut, tree) * 2;
            d = Math.max(d, distance(nut, tree) - distance(nut, squirrel));
        }
        return dist - d;
    }

    // two points Manhattan distance.
    private int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
