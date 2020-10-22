package LeetCode.LC_801_1000.LC1041;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // north, east, south, west.
        int x = 0, y = 0, idx = 0;
        for(char ch : instructions.toCharArray()) {
            if(ch == 'L') {
                idx = (idx + 3) % 4;
            } else if(ch == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
        }
        return x == 0 && y == 0 || idx != 0;
    }
}
