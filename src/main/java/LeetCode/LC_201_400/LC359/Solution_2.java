package LeetCode.LC_201_400.LC359;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 2: map.
 */
public class Solution_2 {
    class Logger {
        private Map<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)) {
                int oldTimeStamp = map.get(message);
                if (timestamp - oldTimeStamp >= 10) {
                    map.put(message, timestamp);
                    return true;
                } else {
                    return false;
                }
            }
            map.put(message, timestamp);
            return true;
        }
    }
}
