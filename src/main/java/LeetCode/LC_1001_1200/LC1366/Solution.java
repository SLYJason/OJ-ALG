package LeetCode.LC_1001_1200.LC1366;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Solution: sorting.
 */
public class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length <= 1) return votes[0];
        int n = votes[0].length();

        // step 1: process the input, build a map.
        Map<Character, Team> map = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char team = vote.charAt(i);
                if (!map.containsKey(team)) map.put(team, new Team(team, n));
                map.get(team).ranks[i]++;
            }
        }
        List<Team> list = new ArrayList<>();
        for (Map.Entry<Character, Team> entry : map.entrySet()) list.add(entry.getValue());

        // step 2: sort teams in descending order, most position-one comes first, i.e. descending order.
        Collections.sort(list, (t1, t2) -> {
            int[] r1 = t1.ranks, r2 = t2.ranks;
            for (int i = 0; i < n; i++) {
                if (r1[i] == r2[i]) continue;
                return r2[i] - r1[i];
            }
            return t1.name - t2.name;
        });

        // step 3: build the result.
        StringBuilder sb = new StringBuilder();
        for (Team t : list) sb.append(t.name);
        return sb.toString();
    }

    class Team {
        char name;
        int[] ranks;

        Team(char name, int size) {
            this.name = name;
            this.ranks = new int[size];
        }
    }
}
