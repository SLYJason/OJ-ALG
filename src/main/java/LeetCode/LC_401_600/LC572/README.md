# 572: Subtree of Another Tree

### Solution 1: Brute Force
**Time Complexity:** `O(M * N)`. `M` and `N` is the number of nodes in `root` and `subRoot` respectively.

**Space Complexity:** `O(M + N)`.

### Solution 2: String Matching
Use preOrder to serialize both trees, compare t is a substring of s.

**Time Complexity:** `O(M + N)`

**Space Complexity:** `O(M + N)`.

### Solution 3: Recursive
**Time Complexity:** `O(M * N)`.

**Space Complexity:** `O(M + N)`.