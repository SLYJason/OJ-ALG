package LeetCode.LC_601_800.LC733;

/**
 * Solution: DFS.
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(image[sr][sc] == newColor) return image;
        int rows = image.length, cols = image[0].length;
        image[sr][sc] = newColor;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int[] d : directions) {
            int nx = sr + d[0];
            int ny = sc + d[1];
            if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && image[nx][ny] == oldColor) {
                floodFill(image, nx, ny, newColor);
            }
        }
        return image;
    }
}
