# 304: Range Sum Query 2D - Immutable

### Solution: DP
`dp[i][j]` means region sum from `[0, 0]` to `[i, j]`. The region is denoted as rows with length `i` and columns with length `j`.

**Time Complexity:** `construction` takes `O(M * N)`, `sumRegion` takes `O(1)`.

**Space Complexity:** `construction` takes `O(M * N)`, `sumRegion` takes `O(1)`.

### Related
303: Range Sum Query - Immutable.

304: Range Sum Query 2D - Immutable.

307: Range Sum Query - Mutable.