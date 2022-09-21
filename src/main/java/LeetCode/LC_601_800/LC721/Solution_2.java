package LeetCode.LC_601_800.LC721;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * Solution 2: union find.
 */
public class Solution_2 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null) return null;
        if (accounts.size() < 2) return accounts;

        // step 1: build the union find.
        Map<String, Integer> emailIndex = new HashMap<>(); // key: email, value: index of account.
        UnionFind uf = new UnionFind(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailIndex.containsKey(email)) {
                    int preIndex = emailIndex.get(email);
                    uf.union(i, preIndex);
                } else {
                    emailIndex.put(email, i);
                }
            }
        }

        // step 2: merge the accounts.
        Map<Integer, Set<String>> merged = new HashMap<>(); // key: parent index of union find, value: merged emails.
        for (int i = 0; i < accounts.size(); i++) {
            int parent = uf.find(i);
            merged.putIfAbsent(parent, new HashSet<>());
            Set<String> emails = merged.get(parent);

            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                emails.add(account.get(j));
            }
        }

        // step 3: get the result.
        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<Integer, Set<String>> entry : merged.entrySet()) {
            int parent = entry.getKey();
            List<String> emails = new ArrayList<>(entry.getValue());
            String name = accounts.get(parent).get(0);

            Collections.sort(emails);
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int size) {
            parents = new int[size];
            for (int i = 0; i < size; i++) parents[i] = i;
        }

        public int find(int x) {
            if (parents[x] == x) return x;
            parents[x] = find(parents[x]); // path compression
            return parents[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return false;
            parents[px] = py;
            return true;
        }
    }
}
