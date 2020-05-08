package LeetCode.Math;

public class LeetCode1232 {
    // Algorithm: For any given 3 points, if they lie in straight line they must meet:
    // (y - y0) / (x - x0) = (y1 - y0) / (x1 - x0)
    // (x0, y0) 1st point, (x1, y1) 2nd point, (x, y) 3rd point.
    public boolean checkStraightLine(int[][] coordinates) {
        int y0 = coordinates[0][1], y1 = coordinates[1][1];
        int x0 = coordinates[0][0], x1 = coordinates[1][0];
        int dy = y1 - y0, dx = x1 - x0;
        for(int i = 2; i<coordinates.length; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if((y - y0) * dx != (x - x0) * dy) return false;
        }
        return true;
    }
}
