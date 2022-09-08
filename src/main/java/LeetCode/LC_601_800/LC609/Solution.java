package LeetCode.LC_601_800.LC609;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: hashmap.
 */
public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentFileMap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String path : paths) {
            String[] split = path.split(" ");
            String dir = split[0];
            for (int i = 1; i < split.length; i++) {
                String[] info = split[i].split("[()]");
                String file = info[0];
                String content = info[1];
                if (!contentFileMap.containsKey(content)) {
                    contentFileMap.put(content, new ArrayList<>());
                }
                contentFileMap.get(content).add(dir + "/" + file);
            }
        }
        for (Map.Entry<String, List<String>> entry : contentFileMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(contentFileMap.get(entry.getKey()));
            }
        }
        return res;
    }
}
