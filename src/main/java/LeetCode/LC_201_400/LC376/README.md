# 376: Wiggle Subsequence

### Solution 1: 2D DP
`dp[i][0]` means the longest wiggle sequence ends in `i` with increasing pattern at `i`.

`dp[i][1]` means the longest wiggle sequence ends in `i` with decreasing pattern at `i`.

**Time Complexity:** `O(N ^ 2)`.

**Space Complexity:** `O(N)`.

### Solution 2: 1D DP
`up[i]` means the longest wiggle sequence ends in `i` with increasing pattern at `i`.

`down[i]` means the longest wiggle sequence ends in `i` with decreasing pattern at `i`.

Consider 3 scenarios:
1. `nums[i] > nums[i-1]`: means wiggle up. So element at `i-1` must be a **down** position, so `up[i] = down[i-1] + 1` and `down[i] = down[i-1]`.
2. `nums[i] < nums[i-1]`: means wiggle down. So element at `i-1` must be a **up** position, so `down[i] = up[i-1] + 1` and `up[i] = up[i-1]`.
3. `nums[i] == nums[i-1]`: will keep `up[i] = up[i-1]` and `down[i] = down[i-1]`.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.