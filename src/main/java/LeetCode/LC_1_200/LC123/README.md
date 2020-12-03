# 123: Best Time to Buy and Sell Stock III

### Solution 1: Regular DP, Causing TLE
**Important:** This solution is just for interview purpose, not concise and causing TLE.

`dp[i][k]` means max profit at `ith` day at most `k` transactions. There has 2 ways to calculate the `dp[i][k]`:
1. At `ith` day, we do nothing so `ith` day profit is previous profit, i.e. `dp[i][k] = dp[i-1][k]`.
2. At `ith` day, we sell the stock, so it means we have to buy the stock before `ith` day, i.e. `jth` day and `0 <= j <= i`. Thus, the profit at `ith` day becomes: `dp[i][k] = prices[i] - prices[j] + dp[j-1][k-1]`. Here we have to find the maximum `dp[i][k]` so `dp[i][k] = max(prices[i] - prices[j] + dp[j-1][k-1]), 0 <= j <= i`. 

Based on the above conditions, we can calculate `dp[i][k]` as follows:
```
dp[i][k] = max(dp[i-1][k], prices[i] - prices[j] + dp[j-1][k-1]), 0 <= j <= i.
```
**Time Complexity:** `O(K * N^2)`.

**Space Complexity:** `O(K * N)`.

### Solution 2: Improved DP, Still TLE.
From DP recurrence relation from Solution 1, to find maximum `prices[i] - prices[j] + dp[j-1][k-1], 0 <= j <= i`, we can convert it to:
```
max(prices[i] - prices[j] + dp[j-1][k-1]) => prices[i] - min(prices[j] - dp[j-1][k-1]), 0 <= j <= i.
```
**Time Complexity:** `O(K * N^2)`.

**Space Complexity:** `O(K * N)`.

### Solution 3: Optimized DP
May hard to come up with in an interview.

**Time Complexity:** `O(K * N)`.

**Space Complexity:** `O(K * N)`.

### Solution 4: DP
For 1st transaction, we buy as low as we can, and sell as much high as we can. For the 2nd transaction, we integrate the profit of 1st transaction into 2nd transaction's cost, so the max profit will be 2nd transaction's profit.

**Time Complexity:** `O(N)`.

**Time Complexity:** `O(1)`.

### Related
121: Best Time to Buy and Sell Stock.

122: Best Time to Buy and Sell Stock II.

123: Best Time to Buy and Sell Stock III.

188: Best Time to Buy and Sell Stock IV.