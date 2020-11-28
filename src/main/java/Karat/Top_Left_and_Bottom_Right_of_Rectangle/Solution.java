package Karat.Top_Left_and_Bottom_Right_of_Rectangle;

public class Solution {
    public int[][] findRectangles(int[][] matrix) {
        int[][] res = new int[2][2];
        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[0].length; c++) {
                if(matrix[r][c] == 0) {
                    int length = getLength(r, c, matrix, new int[]{0, 1});
                    int width = getLength(r, c, matrix, new int[]{1, 0});
                    res[0] = new int[]{r, c};
                    res[1] = new int[]{r + width - 1, c + length - 1};
                    return res;
                }
            }
        }
        return new int[][]{{-1, -1}, {-1, -1}};
    }

    private int getLength(int r, int c, int[][] matrix, int[] dir) {
        if(r == matrix.length || c == matrix[0].length || matrix[r][c] == 1) return 0;
        int nr = r + dir[0];
        int nc = c + dir[1];
        return 1 + getLength(nr, nc, matrix, dir);
    }

    private static void printArray(int[][] res) {
        System.out.println("[" + res[0][0] + ", " + res[0][1] + "], [" + res[1][0] + ", " + res[1][1] + "]");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix1 = {{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[][] res1 = s.findRectangles(matrix1);
        System.out.println("test case 1:");
        printArray(res1);

        int[][] matrix2 = {{0, 0, 1, 1}, {0, 0, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}};
        int[][] res2 = s.findRectangles(matrix2);
        System.out.println("test case 2:");
        printArray(res2);

        int[][] matrix3 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        int[][] res3 = s.findRectangles(matrix3);
        System.out.println("test case 3:");
        printArray(res3);
    }
}
