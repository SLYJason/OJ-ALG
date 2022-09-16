package LeetCode.LC_801_1000.LC826;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution 2: two pointers
 */
public class Solution_2 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(Job::getDifficulty)); // difficulty low -> high
        Arrays.sort(worker); // worker skill low -> high

        int maxProfit = 0, i = 0, best = 0;
        for (int skill : worker) {
            while (i < n && skill >= jobs[i].getDifficulty()) {
                best = Math.max(best, jobs[i].getProfit());
                i++;
            }
            maxProfit += best;
        }
        return maxProfit;
    }
}
