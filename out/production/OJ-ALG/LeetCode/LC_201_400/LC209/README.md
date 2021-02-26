# 209: Minimum Size Subarray Sum

### LC209 and LC862 Difference
Both 209 and 862 asks to find a contiguous subarray's sum >= K. However, LC209 only has positive numbers but LC862 has a mix of positive and negative numbers.

In an interview, the 862 could be treated as a follow up.

### Solution 1: prefixSum + TreeMap
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 2: Sliding Window
The logic is pretty similar to **LC76: Minimum Window Substring**, it needs to expand the window and contract the window.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related:
209: Minimum Size Subarray Sum.

325: Maximum Size Subarray Sum Equals k.

560: Subarray Sum Equals K.

862: Shortest Subarray with Sum at Least K.