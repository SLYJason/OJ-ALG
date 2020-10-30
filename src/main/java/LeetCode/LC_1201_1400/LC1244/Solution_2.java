package LeetCode.LC_1201_1400.LC1244;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * Solution 1: using TreeSet.
 */
public class Solution_2 {
    class Leaderboard {
        Map<Integer, Player> map;
        TreeSet<Player> set;
        public Leaderboard() {
            map = new HashMap();
            set = new TreeSet<>((p1, p2) -> p1.score == p2.score ? p1.playerId - p2.playerId : p2.score - p1.score); // sort by score in descending order, if they are equal, sort by playerId.
        }

        // Time Complexity: O(logN).
        public void addScore(int playerId, int score) {
            Player player;
            if(map.containsKey(playerId)) {
                player = map.get(playerId);
                set.remove(player);
                player.score += score;
            } else {
                player = new Player(playerId, score);
                map.put(playerId, player);
            }
            set.add(player);
        }

        // Time Complexity: O(K * logN).
        public int top(int K) {
            int topK = 0;
            Iterator<Player> ite = set.iterator();
            while(ite.hasNext() && K>0) {
                topK += ite.next().score;
                K--;
            }
            return topK;
        }

        // Time Complexity: O(logN).
        public void reset(int playerId) {
            Player player = map.get(playerId);
            map.remove(playerId);
            set.remove(player);
        }

        class Player{
            int playerId;
            int score;
            public Player(int playerId, int score) {
                this.playerId = playerId;
                this.score = score;
            }
        }
    }
}
