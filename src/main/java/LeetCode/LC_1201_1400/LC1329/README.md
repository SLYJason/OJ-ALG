# 1329: Sort the Matrix Diagonally

### Solution 1: HashMap + PriorityQueue
All cells in the same diagonal (i, j) has the same difference: i - j. We can use this difference as key of the hashmap.

**Time Complexity:** `O(M * N * log(min(M, N))`, `M` is the number of rows, `N` is the number of columns, the longest diagonal contains no more than `min(M, N)` elements.

**Space Complexity:** `O(M * N)`.

### Solution 2: Sort Diagonals One by One
We can reduce the space in this method.

**Time Complexity:** `O(M * N * log(min(M, N))`, `M` is the number of rows, `N` is the number of columns, the longest diagonal contains no more than `min(M, N)` elements.

**Space Complexity:** `min(M, N)`.
