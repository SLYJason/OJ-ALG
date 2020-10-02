package Amazon.OA7;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * TODO: how to optimize?
 */
public class Solution {
    public int[] timeToPassTurnstile(int numCustomers, int[] arrTime, int[] direction) {
        int[] res = new int[numCustomers];
        Map<Integer, List<int[]>> map = new HashMap(); // K: time i, V: int[]{customer[i], direction[i]}.
        Queue<int[]> entryQ = new LinkedList<>();
        Queue<int[]> exitQ = new LinkedList<>();
        int prevDir = -1;

        for(int i=0; i<arrTime.length; i++) {
            if(!map.containsKey(arrTime[i])) map.put(arrTime[i], new ArrayList<>());
            map.get(arrTime[i]).add(new int[]{i, direction[i]});
        }
        int elapsedTime = 0;
        while(numCustomers > 0) {
            if(map.containsKey(elapsedTime)) {
                List<int[]> customers = map.get(elapsedTime);
                for(int[] pair : customers) {
                    if(pair[1] == 0) { // direction 0 means enter.
                        entryQ.add(pair);
                    } else { // direction 1 means exit.
                        exitQ.add(pair);
                    }
                }
            }

            if(entryQ.isEmpty() && exitQ.isEmpty()) {
                elapsedTime++;
                prevDir = -1;
                continue;
            }
            int[] cur;
            if(!entryQ.isEmpty() && !exitQ.isEmpty()) {
                switch (prevDir) {
                    case -1: // previous was not used, so exit goes first.
                        cur = exitQ.poll();
                        res[cur[0]] = elapsedTime;
                        prevDir = 1;
                        elapsedTime++;
                        numCustomers--;
                        break;
                    case 0: // enter goes first.
                        cur = entryQ.poll();
                        res[cur[0]] = elapsedTime;
                        prevDir = 0;
                        elapsedTime++;
                        numCustomers--;
                        break;
                    case 1: // exit goes first.
                        cur = exitQ.poll();
                        res[cur[0]] = elapsedTime;
                        prevDir = 1;
                        elapsedTime++;
                        numCustomers--;
                        break;
                }
                continue;
            }
            if(!entryQ.isEmpty()) {
                cur = entryQ.poll();
                res[cur[0]] = elapsedTime;
                prevDir = 0;
                elapsedTime++;
                numCustomers--;
            }
            if(!exitQ.isEmpty()) {
                cur = exitQ.poll();
                res[cur[0]] = elapsedTime;
                prevDir = 1;
                elapsedTime++;
                numCustomers--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int numCustomers1 = 4;
        int[] arrTime1 = {0, 0, 1, 5};
        int[] direction1 = {0, 1, 1, 0};
        int numCustomers2 = 5;
        int[] arrTime2 = {0, 1, 1, 3, 3};
        int[] direction2 = {0, 1, 0, 0, 1};
        Solution s = new Solution();
        for(int i: s.timeToPassTurnstile(numCustomers1, arrTime1, direction1)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i: s.timeToPassTurnstile(numCustomers2, arrTime2, direction2)) {
            System.out.print(i + " ");
        }
    }
}
