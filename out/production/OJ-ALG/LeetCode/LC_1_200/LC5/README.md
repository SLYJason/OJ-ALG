# 5: Longest Palindromic Substring

### Solution 1: DP
`dp[i][j]` represents substring `[i, j]` is palindrome or not.

**Time Complexity:** `O(N ^ 2)`, `N` is the length of string `s`.

**Space Complexity:** `O(N ^ 2)`, `N` is the length of string `s`.

### Solution 2: Expand from Center

**Time Complexity:** `O(N ^ 2)`, `N` is the length of string `s`.

**Space Complexity:** `O(1)`, `N` is the length of string `s`.