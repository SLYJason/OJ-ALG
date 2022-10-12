package Amazon.Onsite.Most_Number_Warehouses;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int mostWarehouses(int[][] warehouses) {
        Arrays.sort(warehouses, Comparator.comparingInt(w -> w[0]));
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] warehouse : warehouses) {
            while (!pq.isEmpty() && pq.peek() < warehouse[0]) {
                pq.poll();
            }
            pq.offer(warehouse[1]);
            max = Math.max(max, pq.size());
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] warehouses = {{1990, 1999}, {1993, 2000}, {1995, 2000}, {2003, 2004}, {2005, 2010}};
        System.out.println(mostWarehouses(warehouses));
    }
}
