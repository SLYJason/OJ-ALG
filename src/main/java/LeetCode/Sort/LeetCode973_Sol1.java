package LeetCode.Sort;

import java.util.Arrays;

/**
 * Solution 1: brute force, intuitive thoughts.
 */
public class LeetCode973_Sol1 {
    public int[][] kClosest(int[][] points, int K) {
        Point[] arr = new Point[points.length];
        for(int i=0; i<points.length; i++) {
            arr[i] = new Point(points[i][0], points[i][1]);
        }
        Arrays.sort(arr);
        int[][] res = new int[K][2];
        for(int i=0; i<K; i++) {
            res[i][0] = arr[i].x;
            res[i][1] = arr[i].y;
        }

        return res;
    }

    class Point implements Comparable<Point>{
        public int x;
        public int y;
        public int distance;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = x * x + y * y;
        }

        @Override
        public int compareTo(Point p) {
            return this.distance - p.distance;
        }
    }
}
