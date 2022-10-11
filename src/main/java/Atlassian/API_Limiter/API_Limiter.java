package Atlassian.API_Limiter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class API_Limiter {
    int window;
    int limit;
    Map<String, HitCounter> map;
    API_Limiter(int window, int limit) {
        this.window = window;
        this.limit = limit;
        this.map = new HashMap<>();
    }

    public boolean call(String callerId, int timestamp) {
        if (!map.containsKey(callerId)) {
            HitCounter hitCounter = new HitCounter(this.window);
            hitCounter.hit(timestamp);
            map.put(callerId, hitCounter);
            return true;
        }

        HitCounter hitCounter = map.get(callerId);
        hitCounter.hit(timestamp);
        return hitCounter.getHits(timestamp) <= limit;
    }

    public static void main(String[] args) {
        API_Limiter apiLimiter = new API_Limiter(10, 2);
        System.out.println("caller_A hit 0: " + apiLimiter.call("caller_A", 0));
        System.out.println("caller_A hit 0: " + apiLimiter.call("caller_A", 0));
        System.out.println("caller_A hit 1: " + apiLimiter.call("caller_A", 1));
        System.out.println("caller_A hit 2: " + apiLimiter.call("caller_A", 2));
        System.out.println("caller_A hit 12: " + apiLimiter.call("caller_A", 12));
        System.out.println("caller_A hit 13: " + apiLimiter.call("caller_A", 13));
        System.out.println("caller_A hit 14: " + apiLimiter.call("caller_A", 14));
        System.out.println("caller_A hit 16: " + apiLimiter.call("caller_A", 16));
        System.out.println("caller_A hit 17: " + apiLimiter.call("caller_A", 17));
        System.out.println("caller_A hit 26: " + apiLimiter.call("caller_A", 26));
    }
}

class HitCounter {
    int window;
    Deque<Hit> queue;
    int count;

    public HitCounter(int window) {
        this.window = window;
        this.queue = new LinkedList<>();
        this.count = 0;
    }

    public void hit(int timestamp) {
        if (queue.isEmpty()) {
            queue.offer(new Hit(timestamp, 1));
            count = 1;
            return;
        }
        Hit hit = queue.getLast();
        if (hit.timestamp == timestamp) {
            hit.hits++;
        } else {
            queue.offer(new Hit(timestamp, 1));
        }
        count++;
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek().timestamp <= timestamp - window) {
            count -= queue.poll().hits;
        }
        return count;
    }

    class Hit {
        int timestamp;
        int hits;

        Hit(int timestamp, int hits) {
            this.timestamp = timestamp;
            this.hits = hits;
        }
    }
}
