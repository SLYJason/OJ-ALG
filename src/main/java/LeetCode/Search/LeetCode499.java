package LeetCode.Search;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class LeetCode499 {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Map<String, int[]> directions = new HashMap<String, int[]>() {
            {
                put("u", new int[]{-1, 0});
                put("d", new int[]{1, 0});
                put("l", new int[]{0, -1});
                put("r", new int[]{0, 1});
            }
        };
        Point[][] points = new Point[maze.length][maze[0].length];
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[0].length; j++) {
                points[i][j] = new Point(i, j);
            }
        }
        Queue<Point> queue = new LinkedList();
        queue.offer(new Point(ball[0], ball[1], "", 0));
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            if (points[point.x][point.y].compareTo(point) <= 0) continue;
            points[point.x][point.y] = point;
            for (Map.Entry<String, int[]> d : directions.entrySet()) {
                int x = point.x;
                int y = point.y;
                int distance = point.distance;
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0 && (x != hole[0] || y != hole[1])) {
                    x += d.getValue()[0];
                    y += d.getValue()[1];
                    distance++;
                }
                if (x != hole[0] || y != hole[1]) { // check the hole
                    x -= d.getValue()[0];
                    y -= d.getValue()[1];
                    distance--;
                }
                queue.offer(new Point(x, y, point.path + d.getKey(), distance));
            }
        }
        return points[hole[0]][hole[1]].distance == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].path;
    }

    class Point implements Comparable<Point>{
        public int x;
        public int y;
        public String path;
        public int distance = Integer.MAX_VALUE;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Point(int x, int y, String path, int distance) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.distance = distance;
        }
        public int compareTo(Point point) {
            return distance == point.distance ? path.compareTo(point.path) : distance - point.distance;
        }
    }
}
