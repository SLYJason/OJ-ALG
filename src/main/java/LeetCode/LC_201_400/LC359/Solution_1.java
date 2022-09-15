package LeetCode.LC_201_400.LC359;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: queue + set.
 */
public class Solution_1 {
    class Logger {
        Queue<Log> queue;
        Set<String> set;
        /** Initialize your data structure here. */
        public Logger() {
            queue = new ArrayDeque<>();
            set = new HashSet<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            // clean up the queue to remove the obsolete messages.
            while (!queue.isEmpty() && queue.peek().timestamp + 10 <= timestamp) {
                Log log = queue.poll();
                set.remove(log.message);
            }
            if (!set.contains(message)) {
                queue.offer(new Log(timestamp, message));
                set.add(message);
                return true;
            }
            return false;
        }

        class Log {
            public int timestamp;
            public String message;
            public Log(int timestamp, String message) {
                this.timestamp = timestamp;
                this.message = message;
            }
        }
    }

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
}