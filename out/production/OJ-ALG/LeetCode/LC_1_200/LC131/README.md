# 131: Palindrome Partitioning

### Solution 1: Backtrack
Time Complexity: `O(N * 2^N)`, `N` is the length of `s`. For a string there will be `N-1` partitions, so it has `2 ^ (N-1)` partitions. And for `isPalindrome()`, time complexity is `O(N)`, so total is `O(N * 2^N)`.

Space Complexity: `O(N)`.

### Solution 2: Backtrack + DP.
Time Complexity: `O(N^2 + 2^N) = O(2^N)`. `N^2` comes from `dp` array generation.

Space Complexity: `O(N)`.

### Related
131: Palindrome Partitioning.

132: Palindrome Partitioning II.