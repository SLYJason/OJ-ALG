package LeetCode.LC_801_1000.LC826;

class Job {
    private final int difficulty;
    private final int profit;

    public Job(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getProfit() {
        return profit;
    }

    public String toString() {
        return difficulty + "->" + profit;
    }
}
