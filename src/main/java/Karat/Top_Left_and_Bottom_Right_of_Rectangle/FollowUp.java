package Karat.Top_Left_and_Bottom_Right_of_Rectangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FollowUp {
    public List<int[][]> findRectangles(int[][] matrix) {
        List<int[][]> res = new ArrayList<>();
        int[][] dirs = {{0, 1}, {1, 0}};
        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[0].length; c++) {
                if(matrix[r][c] == 0) {
                    matrix[r][c] = 1;
                    int bottom = r;
                    int right = c;
                    // BFS logic.
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});
                    while(!queue.isEmpty()) {
                        int[] points = queue.poll();
                        for(int[] dir : dirs) {
                            int nr = points[0] + dir[0];
                            int nc = points[1] + dir[1];
                            if(nr < matrix.length && nc < matrix[0].length && matrix[nr][nc] == 0) {
                                matrix[nr][nc] = 1;
                                bottom = Math.max(bottom, nr);
                                right = Math.max(right, nc);
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    res.add(new int[][]{{r, c}, {bottom, right}});
                }
            }
        }
        return res;
    }

    private static void printArray(List<int[][]> res) {
        for(int[][] points : res) {
            System.out.println("[" + points[0][0] + ", " + points[0][1] + "], [" + points[1][0] + ", " + points[1][1] + "]");
        }
    }

    public static void main(String[] args) {
        FollowUp f = new FollowUp();
        int[][] matrix1 = {{0, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        List<int[][]> res1 = f.findRectangles(matrix1);
        System.out.println("test case 1:");
        printArray(res1);

        int[][] matrix2 = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        List<int[][]> res2 = f.findRectangles(matrix2);
        System.out.println("test case 2:");
        printArray(res2);

        int[][] matrix3 = {{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}};
        List<int[][]> res3 = f.findRectangles(matrix3);
        System.out.println("test case 3:");
        printArray(res3);
    }
}
