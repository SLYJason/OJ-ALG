# 1337: The K Weakest Rows in a Matrix

### Solution 1: Linear Search + Max Heap
**Time Complexity:** `O(M * N * logk)`.

**Space Complexity:** `O(k)`.

### Solution 2: Binary Search + Max Heap
It's an optimization based on Solution_1.

**Time Complexity:** `O(M * logN * logk)`.

**Space Complexity:** `O(k)`.

### Solution 3: Vertical Traversal
Traverse `mat` by column, when meet `0` check its left is `1` or not. If it is `1`, current row is the weakest row. Fill the output array until we find `k` weakest rows.

**Time Complexity:** `O(M * N)`.

**Space Complexity:** `O(1)`.
