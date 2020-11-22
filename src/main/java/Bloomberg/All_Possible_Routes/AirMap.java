package Bloomberg.All_Possible_Routes;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class AirMap {
    Map<String, List<String>> graph = new HashMap<>();
    public static void main(String args[] ) throws Exception {
        AirMap airMap = new AirMap();
        airMap.add_route("A", "B");
        airMap.add_route("B", "A");
        airMap.add_route("A", "C");
        airMap.add_route("C", "A");
        airMap.add_route("A", "D");
        airMap.add_route("D", "A");
        airMap.add_route("B", "C");
        airMap.add_route("C", "B");
        airMap.add_route("B", "D");
        airMap.add_route("D", "B");
        airMap.print_all_routes("C", "D");
    }

    private void add_route(String start, String destination) {
        if(!graph.containsKey(start)) graph.put(start, new ArrayList<>());
        graph.get(start).add(destination);
    }

    private void print_all_routes(String start, String destination) {
        List<String> path = new ArrayList<>();
        path.add(start);
        dfs(start, destination, path);
    }

    private void dfs(String start, String destination, List<String> path) {
        if(start.equals(destination)) {
            System.out.println(path);
            return;
        }
        for(String neighbor : graph.get(start)) {
            if(path.contains(neighbor)) continue;
            path.add(neighbor);
            dfs(neighbor, destination, path);
            path.remove(path.size()-1);
        }
    }
}
