package LeetCode.LC_201_400.LC353;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayDeque;

public class Solution {
    class SnakeGame {
        Map<String, int[]> dirs;
        int[][] game;
        int[][] food;
        int foodIndex;
        int score;
        int rows;
        int cols;
        int r;
        int c;
        ArrayDeque<String> body;
        Set<String> bodySet;

        public SnakeGame(int width, int height, int[][] food) {
            this.dirs = new HashMap<>();
            dirs.put("R", new int[]{0, 1});
            dirs.put("D", new int[]{1, 0});
            dirs.put("L", new int[]{0, -1});
            dirs.put("U", new int[]{-1, 0});
            this.game = new int[height][width];
            this.food = food;
            this.foodIndex = 0;
            this.score = 0;
            this.rows = height;
            this.cols = width;
            this.r = 0; // head position.
            this.c = 0; // head position.
            this.body = new ArrayDeque<>();
            body.offerFirst("0-0");
            this.bodySet = new HashSet<>(); // use a set for fast lookup.
            bodySet.add("0-0");
        }

        public int move(String direction) {
            int nr = r + dirs.get(direction)[0];
            int nc = c + dirs.get(direction)[1];
            String encoded = nr + "-" + nc;
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) return -1; // reach boundary.
            if (bodySet.contains(encoded) && !body.getLast().equals(encoded)) return -1; // eat self. This case !body.getLast().equals(encoded) is to handle the snake head next move is reaching out to the tail, whihc is a valid move.
            if (foodIndex < food.length && nr == food[foodIndex][0] && nc == food[foodIndex][1]) {
                score++;
                foodIndex++;
            } else {
                bodySet.remove(body.removeLast());
            }
            r = nr;
            c = nc;
            body.offerFirst(encoded);
            bodySet.add(encoded);
            return score;
        }
    }
}
