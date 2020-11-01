package LeetCode.LC_1201_1400.LC1274;

/**
 * Solution: divide and conquer.
 */
public class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if(!sea.hasShips(topRight, bottomLeft)) return 0; // base case 1.
        if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1; // base case 2, a single point.

        int midX = (topRight[0] + bottomLeft[0])/2;
        int midY = (topRight[1] + bottomLeft[1])/2;
        return countShips(sea, new int[]{midX, midY}, bottomLeft) // region 1, no overlap.
                + countShips(sea, topRight, new int[]{midX+1, midY+1}) // region 2, no overlap.
                + countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY+1}) // region 3, no overlap.
                + countShips(sea, new int[]{topRight[0], midY}, new int[]{midX+1, bottomLeft[1]}); // region 4, no overlap.
    }
}

// This is Sea's API interface.
abstract class Sea {
    public abstract boolean hasShips(int[] topRight, int[] bottomLeft);
}
