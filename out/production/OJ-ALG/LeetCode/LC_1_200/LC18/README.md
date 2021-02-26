# 18: 4Sum

### Solution 1
Using same logic as LC15 3SUM.

**Time Complexity:** `O(N^3)`.

**Space Complexity:** `O(1)`.

### Solution 2: K Sum - Follow Up
For the `KSum` problem, the goal is reduced to `2Sum` and then use two pointers to solve it.

**Time Complexity:** `O(N^(K-1))`.

**Space Complexity:** `O(N)`, we need `O(K)` space for the recursion, `K` can be `N` in the worst case.

### Related:
18: 4Sum.

454: 4Sum II.