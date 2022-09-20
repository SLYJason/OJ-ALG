package LeetCode.LC_601_800.LC721;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null) return null;
        if (accounts.size() < 2) return accounts;
        List<List<String>> res = new LinkedList<>();
        Map<String, Set<String>> graph = new HashMap<>(); // key: email node, value: neighbors
        Map<String, String> map = new HashMap<>(); // key: email, value: name.

        // step 1: build the graph.
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                map.put(account.get(i), name);
                if (!graph.containsKey(account.get(i))) graph.put(account.get(i), new HashSet<>());
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        // step 2: DFS
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String email = entry.getKey(), name = entry.getValue();
            if (visited.contains(email)) continue;
            List<String> emails = new LinkedList<>();

            dfs(graph, email, visited, emails);

            Collections.sort(emails);
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }

    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> emails) {
        if (visited.contains(email)) return;
        visited.add(email);
        emails.add(email);
        for (String neighbor : graph.get(email)) {
            dfs(graph, neighbor, visited, emails);
        }
    }
}
