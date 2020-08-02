package LeetCode.Design;

import java.util.Map;
import java.util.HashMap;

public class LeetCode359 {
    class Logger {
        Map<String, Integer> cache;
        /** Initialize your data structure here. */
        public Logger() {
            cache = new HashMap();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(!cache.containsKey(message)) {
                cache.put(message, timestamp);
                return true;
            }
            int last_timestamp = cache.get(message);
            if(timestamp - last_timestamp >= 10) {
                cache.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
