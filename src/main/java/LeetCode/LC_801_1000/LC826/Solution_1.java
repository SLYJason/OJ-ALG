package LeetCode.LC_801_1000.LC826;

import java.util.Arrays;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }

        Arrays.sort(jobs, (j1, j2) -> j1.getProfit() == j2.getProfit() ?
                j1.getDifficulty() - j2.getDifficulty() : j2.getProfit() - j1.getProfit());

        int maxProfit = 0;
        for (int w : worker) {
            for (Job job : jobs) {
                if (w >= job.getDifficulty()) {
                    maxProfit += job.getProfit();
                    break;
                }
            }
        }
        return maxProfit;
    }
}
