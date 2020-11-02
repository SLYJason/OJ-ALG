package LeetCode.LC_1401_1600.LC1583;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // Step 1: process preferences.
        Map<Integer, Integer>[] preferMap = new HashMap[n]; // ith peron preference map, K: preference person, V: preference rank.
        for(int i=0; i<n; i++) {
            preferMap[i] = new HashMap();
            for(int j=0; j<n-1; j++) {
                preferMap[i].put(preferences[i][j], j);
            }
        }
        // Step 2: process pairs.
        int[] pairsMap = new int[n];
        for(int[] pair : pairs) {
            pairsMap[pair[0]] = pair[1];
            pairsMap[pair[1]] = pair[0];
        }
        // Step 3: find unhappy friends.
        int unhappy = 0;
        for(int i=0; i<n; i++) {
            for(int j : preferences[i]) {
                if(preferMap[i].get(j) < preferMap[i].get(pairsMap[i])
                        && preferMap[j].get(i) < preferMap[j].get(pairsMap[j])) {
                    unhappy++;
                    break; // because i only pair with one friend, so need to break here.
                }
            }
        }
        return unhappy;
    }
}
