package Amazon.OA.The_Largest_Item_Association;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;


public class Solution {
    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // write your code here
        List<List<String>> merged = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap();
        // building graph.
        for(PairString pair : itemAssociation) {
            if(!graph.containsKey(pair.first)) {
                graph.put(pair.first, new ArrayList<>());
            }
            graph.get(pair.first).add(pair.second);
            if(!graph.containsKey(pair.second)) {
                graph.put(pair.second, new ArrayList<>());
            }
            graph.get(pair.second).add(pair.first);
        }
        Set<String> visited = new HashSet<>();
        for(String key : graph.keySet()) {
            List<String> list = new ArrayList<>();
            dfs(key, list, graph, visited);
            if(!list.isEmpty()) {
                Collections.sort(list);
                merged.add(list);
            }
        }
        // sort the merged results by each list size, if sizes are equal, sort them lexicographical.
        Collections.sort(merged, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2) {
                if(l1.size() == l2.size()) {
                    for(int i=0; i<l1.size(); i++) {
                        if(l1.get(i).equals(l2.get(i))) continue;
                        return l1.get(i).compareTo(l2.get(i));
                    }
                }
                return l2.size() - l1.size();
            }
        });
        return merged.get(0);
    }

    private void dfs(String cur, List<String> list, Map<String, List<String>> graph, Set<String> visited) {
        if(visited.contains(cur)) return;
        visited.add(cur);
        list.add(cur);
        for(String neighbor : graph.get(cur)) {
            dfs(neighbor, list, graph, visited);
        }
    }

    public static void main(String[] args) {
        List<PairString> itemAssociation1 = new ArrayList(){
            {
                add(new PairString("item1", "item2"));
                add(new PairString("item3", "item4"));
                add(new PairString("item4", "item5"));
            }
        };
        List<PairString> itemAssociation2 = new ArrayList(){
            {
                add(new PairString("item1", "item2"));
                add(new PairString("item3", "item4"));
                add(new PairString("item4", "item5"));
                add(new PairString("item6", "item7"));
                add(new PairString("item6", "item8"));
            }
        };
        List<PairString> itemAssociation3 = new ArrayList(){
            {
                add(new PairString("item1", "item2"));
                add(new PairString("item4", "item5"));
                add(new PairString("item3", "item4"));
                add(new PairString("item1", "item4"));
            }
        };
        Solution s = new Solution();
        System.out.println(s.largestItemAssociation(itemAssociation1));
        System.out.println(s.largestItemAssociation(itemAssociation2));
        System.out.println(s.largestItemAssociation(itemAssociation3));
    }
}
