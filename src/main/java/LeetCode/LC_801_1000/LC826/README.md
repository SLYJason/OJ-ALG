# 826: Most Profit Assigning Work

### Solution 1: Brute Force
Build a `Job` which contains (difficulty, profit) and sort all them based on the profit, if the profit has a tie, sort it based on the difficulty. Then iterate all workers to find the max profit.

**Time Complexity:** `O(N * logN + M ^ 2)`. `N` is the length of difficulty and profit, `M` is the number of worker. Sorting takes `O(N * logN)` and iterate the workers to find max profit takes `O(M ^ 2)`.

**Space Complexity:** `O(N)`.

### Solution 2: Two Pointers
A slight optimization of solution 1. The key observation is if a lower worker can do max profit, the higher worker must could do the same profit at least.

**Time Complexity:** `O(N * logN + M * logM)`. Only soring <difficulty, profit> and worker takes time.

**Space Complexity:** `O(N)`.
