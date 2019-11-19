package LeetCode;

public class LeetCode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor) return image;
        dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (image[r][c] == oldColor) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, oldColor, newColor);
            if (c >= 1) dfs(image, r, c-1, oldColor, newColor);
            if (r < image.length-1) dfs(image, r+1, c, oldColor, newColor);
            if (c < image[0].length-1) dfs(image, r, c+1, oldColor, newColor);
        }
    }
}
