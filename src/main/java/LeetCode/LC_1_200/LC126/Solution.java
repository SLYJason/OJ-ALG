package LeetCode.LC_1_200.LC126;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: BFS + DFS.
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return new ArrayList();
        Set<String> dict = new HashSet(wordList); // conver wordList to Set.
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> nodeNeighbors = new HashMap();
        Map<String, Integer> distance = new HashMap();

        buildGraph(beginWord, endWord, dict, nodeNeighbors, distance); // building a undirected graph.
        dfs(beginWord, endWord, new ArrayList(), nodeNeighbors, distance, res);
        return res;
    }

    private void dfs(String currWord, String endWord, ArrayList<String> path, Map<String, List<String>> graph, Map<String, Integer> distance, List<List<String>> res) {
        path.add(currWord);
        if (endWord.equals(currWord)) {
            res.add(new ArrayList(path));
        } else {
            for (String neighbor : graph.get(currWord)) {
                if (distance.get(neighbor) == distance.get(currWord) + 1) {
                    dfs(neighbor, endWord, path, graph, distance, res);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private void buildGraph(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        dict.add(beginWord);
        for(String str : dict) nodeNeighbors.put(str, new ArrayList<String>()); // nodeNeighbors initialization.
        distance.put(beginWord, 0); // distance initialization.

        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        boolean found = false;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String curr = queue.poll();
                int currDistance = distance.get(curr);
                List<String> neighbors = getNeighbors(curr, dict);
                for(String neighbor : neighbors) {
                    nodeNeighbors.get(curr).add(neighbor);
                    if(!distance.containsKey(neighbor)) { // not visited
                        distance.put(neighbor, currDistance+1);
                        if(neighbor.equals(endWord)) {
                            found = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if(found) break;
        }
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList();
        char[] arr = word.toCharArray();
        for(int i=0; i<arr.length; i++) {
            char temp = arr[i];
            for(int j='a'; j<='z'; j++) {
                arr[i] = (char)j;
                if(arr[i] == temp) continue;
                String transformed = new String(arr);
                if(dict.contains(transformed)) neighbors.add(transformed);
            }
            arr[i] = temp;
        }
        return neighbors;
    }
}

