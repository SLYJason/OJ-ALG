# 91: Decode Ways

### Solution 1: DFS + Memorization
**Time Complexity:** `O(N)`, `N` is the length of string. Memoization helps in pruning the recursion tree and hence decoding for an index only once.

**Space Complexity:** `O(N)`, `N` is the length of string.

### Solution 2: DP
`dp[i]` means number of ways to decode sub string with length `i`.

**Time Complexity:** `O(N)`, `N` is the length of string.

**Space Complexity:** `O(N)`, `N` is the length of string.

### Related
91: Decode Ways.

639: Decode Ways II.