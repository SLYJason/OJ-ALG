package LeetCode.Sort;

import java.util.Arrays;

/**
 * Solution 3: optimal solution, using quick sort.
 */
public class LeetCode973_Sol3 {
    public int[][] kClosest(int[][] points, int K) {
        int low = 0, high = points.length-1;
        while(low < high) {
            int pivot_index = partition(low, high, points);
            if(pivot_index == K) break;
            if(pivot_index < K) {
                low = pivot_index + 1;
            } else {
                high = pivot_index - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }


    private int partition(int low, int high, int[][] points) {
        int[] pivot = points[high];
        int i = low-1;
        for(int j=low; j<high; j++) {
            if(compare(points[j], pivot) < 0) {
                i++;
                swap(points, i, j);
            }
        }
        swap(points, i+1, high);
        return i+1;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
