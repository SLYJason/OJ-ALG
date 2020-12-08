# 1239: Maximum Length of a Concatenated String with Unique Characters

### Solution 1: Backtrack + DFS
Check all valid combinations and get max length of each of them.

**Time Complexity:** `O(2 ^ N)`, `N` is the input size.

**Time Complexity:** `O(N)`, `N` is the input size, space comes from call stack space.

### Solution 2: DP.
The idea is put all unique combinations into `unique_strings`. Iterate the strings, check current string can be combined with the previous combinations we have found. The rule is the combination string must be **unique**.

**Time Complexity:** `O(N ^ 2)`, `N` is the input size.

**Time Complexity:** `O(N ^ 2)`, `N` is the input size.