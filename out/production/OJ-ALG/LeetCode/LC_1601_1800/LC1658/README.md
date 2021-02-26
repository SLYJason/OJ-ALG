# 1658: Minimum Operations to Reduce X to Zero

### Solution: Sliding Window
Similar to LC1423, we maintain a window that the window's sum meet: `window_sum <= total_sum - x`.

**Base Case 1**: `total_sum` is smaller than `x`, we have no way to reduce `x` to zero.

**Base Case 2**: `total_sum` is equals to `x`, than the answer is array length `n`.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related
1423: Maximum Points You Can Obtain from Cards.

1658: Minimum Operations to Reduce X to Zero.
