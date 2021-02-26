# 413: Arithmetic Slices

### Solution 1: Brute Force
**Time Complexity:** `O(N ^ 2)`.

**Space Complexity:** `O(1)`.

### Solution 2: DP
For recurrence relation `dp[i] = dp[i-1] + 1;`, given `[1, 2, 3, 4, 5, 6]`:
```
i=2: A[0]=1, A[1]=2, A[2]=3 can be a arithmetic slice, so dp[2] = 1.
i=3: A[1]=2, A[2]=3, A[3]=4 can be a arithmetic slice, dp[3] should be number of arithmetic slices ending with A[2] plus one arithmetic slice(A[1], A[2], A[3]).
And so on...
```
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 3: DP, Constant Space
This solution is an optimization based on Solution_2.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related
413: Arithmetic Slices.

446: Arithmetic Slices II - Subsequence.
