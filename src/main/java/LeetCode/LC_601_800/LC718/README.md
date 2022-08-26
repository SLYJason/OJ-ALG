# 718: Maximum Length of Repeated Subarray

### Solution 1: Brute Force - Time Limit Exceeded
**Time Complexity:** `O(N ^ 3)`, `N` is the length of the array assuming both are equal.

**Space Complexity:** `O(1)`.

### Solution 2: DP
`dp[i][j]` means the longest common subarray between `nums1` with length `i` and `nums2` with length `j`, element in `nums1[i-1]` and `nums2[j-1]` must be included.

Recurrence relations: `dp[i][j] = nums1[i-1] == nums2[j-1] ? dp[i-1][j-1] + 1 : 0`.

**Time Complexity:** `O(M * N)`, `M` and `N` are the lengths of `nums1` and `nums2`.
                               
**Space Complexity:** `O(M * N)`.

### Solution 3: Sliding Window
The logic is: fixed `nums1` position, start compare `nums2` first element to every element in `nums1`. Similar, fixed `nums2` position, start compare `nums1` first element to every element in `nums2`.

![chart](LC718.gif)

**Time Complexity:** `O((M + N) * min(M, N))`, `M` and `N` are the lengths of `nums1` and `nums2`.
                               
**Space Complexity:** `O(1)`.

### Follow up
Question: How to Get the Maximum Repeated Subarray?

### Related
718: Maximum Length of Repeated Subarray.

1143: Longest Common Subsequence.