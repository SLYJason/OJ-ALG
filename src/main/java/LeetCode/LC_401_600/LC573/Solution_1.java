package LeetCode.LC_401_600.LC573;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int dist = 0, res = Integer.MAX_VALUE;
        for(int[] nut : nuts) {
            int dr = Math.abs(nut[0] - tree[0]);
            int dc = Math.abs(nut[1] - tree[1]);
            dist += (dr + dc) * 2;
        }
        for(int[] nut : nuts) {
            int temp = dist;
            int dr_nt = Math.abs(nut[0] - tree[0]);
            int dc_nt = Math.abs(nut[1] - tree[1]);
            int dr_ns = Math.abs(nut[0] - squirrel[0]);
            int dc_ns = Math.abs(nut[1] - squirrel[1]);
            temp = temp - (dr_nt + dc_nt) + dr_ns + dc_ns;
            res = Math.min(res, temp);
        }
        return res;
    }
}
