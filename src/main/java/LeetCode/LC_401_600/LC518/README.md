# 518: Coin Change II.

### Solution 1: 2D DP
Base case: 1. `amount` is 0 which means only **one** combination to reach zero money: take zero coins. Or the `coins` is empty, zero combination can reach the `amount` money which is **one**.

`dp[i][j]` means the number of combinations to make up amount `j` by using the first `i` types of coins. Recurrence relations:
1. Not using `i`th coin, only use the first `i - 1` coins to make up amount `j`. Thus `dp[i][j] = dp[i - 1][j]`.
2. Using `i`th coin, thus `dp[i][j] = dp[i][j - coins[i - 1]]`.

**Time Complexity:** `O(A * N)`. `A` is the `amount`, `N` is the length of `coins`.

**Space Complexity:** `O(A * N)`.

### Solution 2: 1D DP
This is an optimized space DP solution. 

**Time Complexity:** `O(A * N)`.

**Space Complexity:** `O(N)`.

### FollowUp
Please output the minimum amount coin combinations.

### Related
322: Coin Change.

518: Coin Change II.