# 325: Maximum Size Subarray Sum Equals k

### Solution: prefixSum
`Map` structure: `K` -> `prefix sum ending in nums[i](inclusive)`, `V` -> `index i of prefixSum`.

**Important:** Some subarray like questions can be solved by sliding window, but this one cannot because we have a mix of positive and negative numbers.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Solution 2:

### Related:
209: Minimum Size Subarray Sum.

325: Maximum Size Subarray Sum Equals k.

560: Subarray Sum Equals K.

862: Shortest Subarray with Sum at Least K.