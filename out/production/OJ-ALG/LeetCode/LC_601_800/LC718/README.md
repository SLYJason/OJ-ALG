# 718: Maximum Length of Repeated Subarray

### Solution 1: DP
`dp[i][j]` means the longest common subarray between `A` with length `i` and `B` with length `j`, element in `A[i-1]` and `B[j-1]` must included.

Recurrence relations: `dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1] + 1 : 0`.

**Time Complexity:** `O(M * N)`, `M` and `N` are the lengths of `A` and `B`.
                               
**Space Complexity:** `O(M * N)`.

### Solution 2: Sliding Window
The logic is: Fixed `A` position, start compare `B` first element to every element in `A`. Similar, fixed `B` position, start compare `A` first element to every element in `B`.

![chart](LC718.gif)

**Time Complexity:** `O((M + N) * min(M, N))`, `M` and `N` are the lengths of `A` and `B`.
                               
**Space Complexity:** `O(1)`.

### Follow up
Question: How to Get the Maximum Repeated Subarray?

### Related
718: Maximum Length of Repeated Subarray.

1143: Longest Common Subsequence.