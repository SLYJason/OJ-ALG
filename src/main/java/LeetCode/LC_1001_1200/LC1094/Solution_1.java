package LeetCode.LC_1001_1200.LC1094;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;
/**
 * Solution 1: PriorityQueue.
 */
public class Solution_1 {
    public boolean carPooling(int[][] trips, int capacity) {
        if (capacity < 1) return false;

        Arrays.sort(trips, Comparator.comparingInt(t -> t[1]));
        int curPassengers = 0;
        PriorityQueue<Trip> pq = new PriorityQueue<>();

        for (int[] trip : trips) {
            int passengers = trip[0], start = trip[1], end = trip[2];

            while (!pq.isEmpty() && pq.peek().end <= start) {
                curPassengers -= pq.poll().passengers;
            }

            curPassengers += passengers;
            pq.offer(new Trip(end, passengers));
            if (curPassengers > capacity) return false;
        }
        return true;
    }

    class Trip implements Comparable<Trip> {
        int end;
        int passengers;

        Trip(int end, int passengers) {
            this.end = end;
            this.passengers = passengers;
        }

        @Override
        public int compareTo(Trip t) {
            return this.end - t.end;
        }
    }
}
