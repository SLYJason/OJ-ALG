package LeetCode.LC_801_1000.LC909;

import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int goal = n * n;
        int[] distances = new int[goal + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int nextDistance = distances[curr] + 1; // the next move minimum distance is nextDistance = distance + 1.
            int start = curr + 1, end = Math.min(curr + 6, goal);
            for (int next = start; next <= end; next++) {
                int[] indices = getIndices(n, next);
                int destination = board[indices[0]][indices[1]];
                if (destination < 0) {
                    destination = next;
                }
                if (distances[destination] == Integer.MAX_VALUE) {
                    distances[destination] = nextDistance;
                    if (destination == goal) {
                        return nextDistance;
                    }
                    queue.offer(destination);
                }
            }
        }
        return -1;
    }

    public int[] getIndices(int n, int num) {
        int row = (num - 1) / n, col = (num - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        row = n - 1 - row;
        return new int[]{row, col};
    }
}
