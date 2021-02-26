# 96: Unique Binary Search Trees

### Solution 1: DP Verbose
`dp[i]` means number of unique BST with input `n`. 

For given input `n`, we pick a number `root` in the range `[1, n]`. Then `root` will be used as root, and we need to calculate how many unique BST in left and right respectively.
```
1, 2, 3, ...... root ...... n-2, n-1, n
------left----- root -------right------
```
**Time Complexity:** `O(N^2)`.

**Space Complexity:** `O(N)`.

### Solution 2: DP Concise
Same as Solution 1, just initialize `dp[0] = 1` do the trick.

### Solution 3: Catalan Number
Catalan Number: [Wikipedia](https://en.wikipedia.org/wiki/Catalan_number).

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related
95: Unique Binary Search Trees II.

96: Unique Binary Search Trees.
