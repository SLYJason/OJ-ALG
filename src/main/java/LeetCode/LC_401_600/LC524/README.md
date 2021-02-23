# 524: Longest Word in Dictionary through Deleting

### Solution 1: Sorting
**Time Complexity:** `O(N * logN + N * min(NS, ND))`, `N` is the length of `d`, `NS` is the length of `s`, `ND` is the average length of string in `d`.

**Space Complexity:** `O(1)`.

### Solution 2: Without Sorting
**Time Complexity:** `O(N * min(NS, ND))`.

**Space Complexity:** `O(1)`.

