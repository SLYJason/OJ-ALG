package LeetCode.LC_1201_1400.LC1329;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Solution 1: HashMap + PriorityQueue.
 */
public class Solution_1 {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int rows = mat.length, cols = mat[0].length;
        int[][] sorted = new int[rows][cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int key = i - j;
                if(!map.containsKey(key)) map.put(key, new PriorityQueue<>());
                map.get(key).offer(mat[i][j]);
            }
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int key = i - j;
                sorted[i][j] = map.get(key).poll();
            }
        }
        return sorted;
    }
}
